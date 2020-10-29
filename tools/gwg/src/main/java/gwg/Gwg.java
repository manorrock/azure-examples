package gwg;

import java.io.File;
import java.io.FilenameFilter;

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
            for(int i=0; i<arguments.length; i++) {
                if (arguments[i].equals("--baseDirectory")) {
                    baseDirectory = new File(arguments[i+1]);
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
    }
}
