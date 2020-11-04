package gwg;

import gwg.model.Workflow;
import java.io.File;
import java.util.List;
import java.util.Stack;

/**
 * The GitHub Workflow Generator context.
 *
 * @author Manfred Riem (mriem@manorrock.com)
 */
public class GwgContext {

    /**
     * Stores the current file we are processing.
     */
    private File file;

    /**
     * Stores the output filename.
     */
    private String outputFilename;

    /**
     * Stores the script builder.
     */
    private StringBuilder scriptBuilder;

    /**
     * Stores the current snippets we are processing.
     */
    private List snippets;

    /**
     * Stores the stack using for scoping.
     */
    private Stack stack;

    /**
     * Stores the workflow.
     */
    private Workflow workflow;

    /**
     * Constructor.
     */
    public GwgContext() {
        this.stack = new Stack();
    }

    /**
     * Get the file.
     *
     * @return the file.
     */
    public File getFile() {
        return file;
    }

    /**
     * Get the script builder.
     *
     * @return the script builder.
     */
    public StringBuilder getScriptBuilder() {
        return scriptBuilder;
    }

    /**
     * Get the snippets.
     *
     * @return the snippets.
     */
    public List getSnippets() {
        return snippets;
    }

    /**
     * Get the stack.
     *
     * @return the stack.
     */
    public Stack getStack() {
        return stack;
    }

    /**
     * Get the workflow.
     *
     * @return the workflow.
     */
    public Workflow getWorkflow() {
        return workflow;
    }

    /**
     * Set the file.
     *
     * @param file the file.
     */
    public void setFile(File file) {
        this.file = file;
    }

    /**
     * Set the output filename.
     *
     * @param outputFilename the output filename.
     */
    public void setOutputFilename(String outputFilename) {
        this.outputFilename = outputFilename;
    }

    /**
     * Set the script builder.
     *
     * @param scriptBuilder the script builder.
     */
    public void setScriptBuilder(StringBuilder scriptBuilder) {
        this.scriptBuilder = scriptBuilder;
    }

    /**
     * Set the snippets.
     *
     * @param snippets the snippets.
     */
    public void setSnippets(List snippets) {
        this.snippets = snippets;
    }

    /**
     * Set the workflow.
     *
     * @param workflow the workflow.
     */
    public void setWorkflow(Workflow workflow) {
        this.workflow = workflow;
    }
}
