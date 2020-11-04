package gwg.model;

import java.util.List;

/**
 * A GitHub push.
 *
 * @author Manfred Riem (mriem@manorrock.com)
 */
public class Push {
    
    /**
     * Stores the paths.
     */
    private List<String> paths;

    /**
     * Stores the paths.
     * 
     * @return the paths.
     */
    public List<String> getPaths() {
        return paths;
    }

    /**
     * Set the paths.
     * 
     * @param paths the paths.
     */
    public void setPaths(List<String> paths) {
        this.paths = paths;
    }
}
