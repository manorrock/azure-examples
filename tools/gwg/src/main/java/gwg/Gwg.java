package gwg;

import com.vladsch.flexmark.ast.FencedCodeBlock;
import com.vladsch.flexmark.ast.HtmlCommentBlock;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.ast.Document;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.data.MutableDataSet;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * The GitHub Workflow Generator.
 *
 * @author Manfred Riem (manfred.riem@microsoft.com)
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
        List<Node> nodes = collectNodes(file);
        String workflow = generateGitHubWorkflow(file, nodes);
    }

    private List<Node> collectNodes(File file) {
        System.out.println("--- Collecting MarkDown AST nodes");
        ArrayList<Node> nodes = new ArrayList<>();
        try {
            MutableDataSet options = new MutableDataSet();
            Parser parser = Parser.builder(options).build();
            Document document = parser.parseReader(new FileReader(file));
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
    private String generateGitHubWorkflow(File file, List<Node> nodes) {
        System.out.println("--- Generating GitHub workflow");
        ArrayList<Node> workList = new ArrayList<Node>();
        workList.addAll(nodes);
        StringBuilder workflow = new StringBuilder();
        return workflow.toString();
    }
}
