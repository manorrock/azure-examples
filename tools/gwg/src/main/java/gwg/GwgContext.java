package gwg;

import gwg.model.Workflow;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * The GitHub Workflow Generator context.
 *
 * @author Manfred Riem (mriem@manorrock.com)
 */
public class GwgContext {

    /**
     * Stores the file stack.
     */
    private final Stack<File> fileStack;

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
     * Stores the snippet stack.
     */
    private final Stack snippetStack;

    /**
     * Stores the workflow.
     */
    private Workflow workflow;

    /**
     * Constructor.
     */
    public GwgContext() {
        this.fileStack = new Stack();
        this.snippets = new ArrayList();
        this.snippetStack = new Stack();
    }

    /**
     * Get the current file.
     *
     * @return the current file.
     */
    public File getCurrentFile() {
        return fileStack.peek();
    }

    /**
     * Get the file stack.
     *
     * @return the file stack.
     */
    public Stack getFileStack() {
        return fileStack;
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
    public Stack getSnippetStack() {
        return snippetStack;
    }

    /**
     * Get the output filename.
     * 
     * @return the output filename.
     */
    public String getOutputFilename() {
        return outputFilename;
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
     * Set the current file.
     *
     * @param currentFile the current file.
     */
    public void setCurrentFile(File currentFile) {
        fileStack.push(currentFile);
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
