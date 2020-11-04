package gwg;

import com.manorrock.yaml.YAMLLiteralBlock;
import com.manorrock.yaml.YAMLWriter;
import com.vladsch.flexmark.ast.FencedCodeBlock;
import com.vladsch.flexmark.ast.HtmlCommentBlock;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.ast.Document;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.data.MutableDataSet;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import gwg.model.Cron;
import gwg.model.Job;
import gwg.model.On;
import gwg.model.Push;
import gwg.model.Workflow;
import gwg.model.WorkflowDispatch;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The GitHub Workflow Generator.
 *
 * @author Manfred Riem (mriem@manorrock.com)
 */
public class Gwg {

    /**
     * Stores the base directory.
     */
    private File baseDirectory;

    /**
     * Main method.
     *
     * @param arguments the command line arguments.
     */
    public static void main(String[] arguments) {
        Gwg gwg = new Gwg();
        gwg.parseArguments(arguments);
        gwg.run();
    }

    /**
     * Parse the command line arguments.
     *
     * @param arguments the arguments.
     */
    private void parseArguments(String[] arguments) {
        if (arguments.length > 0) {
            for (int i = 0; i < arguments.length; i++) {
                if (arguments[i].equals("--baseDirectory")) {
                    baseDirectory = new File(arguments[i + 1]);
                }
            }
        }
    }

    /**
     * Run the generator.
     */
    private void run() {
        processDirectory(baseDirectory);
    }

    /**
     * Process the given directory.
     *
     * @param directory the directory.
     */
    private void processDirectory(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.getName().equals("README.md")) {
                    processFile(file);
                } else if (file.isDirectory()) {
                    processDirectory(file);
                }
            }
        }
    }

    /**
     * Process the given file.
     *
     * @param file the file to process.
     */
    private void processFile(File file) {
        System.out.println("--- Processing file: " + file);
        GwgContext context = new GwgContext();
        context.setFile(file);
        List<Node> nodes = collectNodes(context, file);
        Workflow workflow = generateGitHubWorkflow(file, nodes);
        StringWriter stringWriter = new StringWriter();
        try {
            YAMLWriter writer = new YAMLWriter(stringWriter);
            writer.writeObject(workflow);
            writer.flush();
        } catch (IOException ioe) {
        }
        System.out.println(stringWriter.toString());
    }

    /**
     * Collect the Markdown nodes.
     *
     * @param context the context.
     * @param includeFile the file to include.
     */
    private List<Node> collectNodes(GwgContext context, File includeFile) {
        System.out.println("--- Collecting MarkDown snippets for - " + includeFile);
        ArrayList<Node> nodes = new ArrayList<>();
        try {
            MutableDataSet options = new MutableDataSet();
            Parser parser = Parser.builder(options).build();
            Document document = parser.parseReader(new FileReader(includeFile));
            Iterator<Node> iterator = document.getChildIterator();
            while (iterator.hasNext()) {
                Node node = iterator.next();
                if (node instanceof HtmlCommentBlock) {
                    HtmlCommentBlock comment = (HtmlCommentBlock) node;
                    System.out.println(comment.getChars().toString());
                    nodes.add(comment);
                }
                if (node instanceof FencedCodeBlock) {
                    FencedCodeBlock code = (FencedCodeBlock) node;
                    if (code.getInfo().toString().equals("shell")) {
                        System.out.println(code.getChars().toString());
                        nodes.add(code);
                    }
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return nodes;
    }

    /**
     * Geenerate the GitHub worflow for the given nodes.
     *
     * @param file the file to generate the workflow for.
     * @param nodes the nodes.
     * @return the GitHub workflow.
     */
    private Workflow generateGitHubWorkflow(File file, List<Node> nodes) {
        System.out.println("--- Generating GitHub workflow");
        ArrayList<Object> workList = new ArrayList<>();
        workList.addAll(nodes);
        Workflow workflow = new Workflow();
        workflow.setName(getRelativeFilename(file));
        HashMap<String, Object> jobs = new HashMap<>();
        Job job = new Job();
        job.setRunsOn("ubuntu-latest");
        jobs.put("validate", job);
        workflow.setJobs(jobs);
        LinkedHashMap<String, Object> login = new LinkedHashMap<>();
        login.put("uses", "azure/login@v1");
        HashMap<String, Object> with = new HashMap<>();
        with.put("creds", "${{ secrets.AZURE_CREDENTIALS }}");
        login.put("with", with);
        job.getSteps().add(login);
        HashMap<String, Object> run = new HashMap<>();
        YAMLLiteralBlock literalBlock = new YAMLLiteralBlock();
        run.put("run", literalBlock);
        StringBuilder builder = new StringBuilder();
        GwgContext context = new GwgContext();
        context.setWorkflow(workflow);
        context.setFile(file);
        context.setSnippets(workList);
        context.setScriptBuilder(builder);
        while (context.getSnippets().size() > 0) {
            processWorkItem(context, builder, context.getSnippets());
            if (context.getSnippets().isEmpty() && !context.getStack().isEmpty()) {
                context.setSnippets((ArrayList) context.getStack().pop());
            }
        }
        literalBlock.setString(context.getScriptBuilder().toString());
        job.getSteps().add(run);
        return workflow;
    }

    /**
     * Get relative filename.
     *
     * @param file the file.
     * @return the relative filename.
     */
    private String getRelativeFilename(File file) {
        return file.getAbsolutePath().substring(baseDirectory.getAbsolutePath().length() + 1);
    }

    /**
     * Process the (Markdown) work items.
     *
     * @param workflow the workflow.
     * @param scriptBuilder the script builder.
     * @param workList the list of work items.
     */
    private void processWorkItem(GwgContext context, StringBuilder scriptBuilder, List workList) {
        Object workItem = workList.remove(0);
        if (workItem instanceof FencedCodeBlock) {
            FencedCodeBlock code = (FencedCodeBlock) workItem;
            scriptBuilder.append(code.getContentChars().toString().trim());
        } else if (workItem instanceof HtmlCommentBlock) {
            HtmlCommentBlock comment = (HtmlCommentBlock) workItem;
            processHtmlCommentBlock(context, comment);
        } else {
            scriptBuilder.append(workItem.toString());
        }
        scriptBuilder.append("\n");
    }

    /**
     * Process the directOnly.
     *
     * @param context the context.
     * @param comment the HtmlCommentBlock.
     */
    private void processDirectOnly(GwgContext context, HtmlCommentBlock comment) {
        if (context.getStack().isEmpty()) {
            List<BasedSequence> content = comment.getContentLines();
            content.remove(0);
            content.remove(content.size() - 1);
            Iterator<BasedSequence> iterator = content.iterator();
            while (iterator.hasNext()) {
                BasedSequence sequence = iterator.next();
                context.getScriptBuilder().append(sequence.toString());
            }
        }
    }

    /**
     * Process the HTML comment block.
     *
     * @param context the context.
     * @param comment the HTML comment block.
     */
    private void processHtmlCommentBlock(GwgContext context, HtmlCommentBlock comment) {
        String firstLine = comment.getContentChars(0, 1).toString();
        if (firstLine.endsWith("\n")) {
            firstLine = firstLine.substring(0, firstLine.length() - 1);
        }
        Pattern pattern = Pattern.compile("<!-- workflow\\.(\\w+)\\((.*)\\).*");
        Matcher matcher = pattern.matcher(firstLine);
        if (matcher.matches()) {
            String action = matcher.group(1);
            if (action.equals("cron")) {
                processWorkflowCron(context, matcher.group(2));
            } else if (action.equals("directOnly")) {
                processDirectOnly(context, comment);
            } else if (action.equals("dispatch")) {
                processWorkflowDispatch(context);
            } else if (action.equals("filename")) {
                processOutputFilename(context, matcher.group(2));
            } else if (action.equals("include")) {
                processInclude(context, matcher.group(2));
            } else if (action.equals("name")) {
                processWorkflowName(context, matcher.group(2));
            } else if (action.equals("pushPath")) {
                processWorkflowPushPath(context, matcher.group(2));
            } else if (action.equals("runsOn")) {
                processJobRunsOn(context, matcher.group(2));
            }
        }
    }

    /**
     * Process the include.
     *
     * <p>
     * The following steps happen upon an include.
     * </p>
     * <ol>
     * <li>The current list of snippets is pushed onto the stack</li>
     * <li>A new empty list of snippets is set for processing</li>
     * <li>The snippets coming from the include file are loaded</li>
     * </li>
     *
     * @param context the context.
     * @param includeFilename the include filename.
     */
    private void processInclude(GwgContext context, String includeFilename) {
        context.getStack().push(context.getSnippets());
        ArrayList snippets = new ArrayList();
        // add loading logic
        context.setSnippets(snippets);
    }

    /**
     * Process the job runs-on.
     *
     * @param context the context.
     * @param runsOn the runs-on.
     */
    private void processJobRunsOn(GwgContext context, String runsOn) {
        if (context.getStack().isEmpty()) {
            Job job = (Job) context.getWorkflow().getJobs().get("validate");
            job.setRunsOn(runsOn);
        }
    }

    /**
     * Process the output filename.
     *
     * @param context the context.
     * @param outputFilename the output filename.
     */
    private void processOutputFilename(GwgContext context, String outputFilename) {
        if (context.getStack().isEmpty()) {
            context.setOutputFilename(outputFilename);
        }
    }

    /**
     * Process the workflow cron.
     *
     * @param context the context.
     * @param cron the cron schedule.
     */
    private void processWorkflowCron(GwgContext context, String cron) {
        if (context.getStack().isEmpty()) {
            On on = context.getWorkflow().getOn();
            if (on.getSchedule() == null) {
                on.setSchedule(new ArrayList<>());
            }
            on.getSchedule().add(new Cron(cron));
        }
    }

    /**
     * Process the workflow dispatch.
     *
     * @param context the context.
     */
    private void processWorkflowDispatch(GwgContext context) {
        if (context.getStack().isEmpty()) {
            On on = context.getWorkflow().getOn();
            if (on.getWorkflow_dispatch() == null) {
                on.setWorkflow_dispatch(new WorkflowDispatch());
            }
        }
    }

    /**
     * Process the workflow name.
     *
     * @param context the context.
     * @param name the workflow name.
     */
    private void processWorkflowName(GwgContext context, String name) {
        if (context.getStack().isEmpty()) {
            context.getWorkflow().setName(name);
        }
    }

    /**
     * Process the workflow push path flag.
     *
     * @param pushPathFlag the push path flag.
     */
    private void processWorkflowPushPath(GwgContext context, String pushPathFlag) {
        if (context.getStack().isEmpty()) {
            Boolean booleanValue = Boolean.parseBoolean(pushPathFlag);
            if (booleanValue) {
                On on = context.getWorkflow().getOn();
                if (on.getPush() == null) {
                    on.setPush(new Push());
                }
                Push push = on.getPush();
                if (push.getPaths() == null) {
                    push.setPaths(new ArrayList<>());
                }
                push.getPaths().add(getRelativeFilename(context.getFile()));
            }
        }
    }
}
