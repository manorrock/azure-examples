package gwg;

import com.vladsch.flexmark.ast.CodeBlock;
import com.vladsch.flexmark.ast.FencedCodeBlock;
import com.vladsch.flexmark.ast.HtmlCommentBlock;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.ast.Document;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.data.MutableDataSet;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

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
        System.out.println(file);
        
        try {
            MutableDataSet options = new MutableDataSet();
            Parser parser = Parser.builder(options).build();
            Document document = parser.parseReader(new FileReader(file));
            Iterator<Node> iterator = document.getChildIterator();
            while(iterator.hasNext()) {
                Node node = iterator.next();
                if (node instanceof HtmlCommentBlock) {
                    HtmlCommentBlock comment = (HtmlCommentBlock) node;
                    System.out.println(comment.getChars().toString());
                }
                if (node instanceof CodeBlock) {
                    CodeBlock code = (CodeBlock) node;
                    System.out.println(code.getChars().toString());
                }
                if (node instanceof FencedCodeBlock) {
                    FencedCodeBlock code = (FencedCodeBlock) node;
                    System.out.println(code.getChars().toString());
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
