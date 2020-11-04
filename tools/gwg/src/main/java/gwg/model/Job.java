package gwg.model;

import com.manorrock.yaml.YAMLSerializerHint;
import java.util.ArrayList;
import java.util.List;

/**
 * A GitHub job.
 *
 * @author Manfred Riem (mriem@manorrock.com)
 */
public class Job {

    /**
     * Get runs-on.
     */
    @YAMLSerializerHint(name = "runs-on")
    private String runsOn;
    
    /**
     * Stores the steps.
     */
    private List steps;
    
    /**
     * Constructor.
     */
    public Job() {
        this.steps = new ArrayList();
    }
    
    /**
     * Get the runs-on.
     * 
     * @return the runs-on.
     */
    public String getRunsOn() {
        return runsOn;
    }
    
    /**
     * Get the steps.
     * 
     * @return the steps.
     */
    public List getSteps() {
        return steps;
    }
    
    /**
     * Set the runs-on.
     * 
     * @param runsOn the runs-on.
     */
    public void setRunsOn(String runsOn) {
        this.runsOn = runsOn;
    }
    
    /**
     * Set the steps.
     * 
     * @param steps the steps.
     */
    public void setSteps(List steps) {
        this.steps = steps;
    }
}
