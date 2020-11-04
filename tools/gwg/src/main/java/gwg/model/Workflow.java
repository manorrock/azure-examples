package gwg.model;

import java.util.Map;

/**
 * A GitHub workflow.
 *
 * @author Manfred Riem (mriem@manorrock.com)
 */
public class Workflow {
    
    /**
     * Stores the on.
     */
    private On on;
    
    /**
     * Stores the name.
     */
    private String name;
    
    /**
     * Stores the jobs.
     */
    private Map<String, Object> jobs;
    
    /**
     * Constructor.
     */
    public Workflow() {
        this.on = new On();
    }
    
    /**
     * Get the on.
     * 
     * @return the on.
     */
    public On getOn() {
        return on;
    }
    
    /**
     * Get the name.
     * 
     * @return the name.
     */
    public String getName() {
        return name;
    }
    
    /**
     * Get the jobs.
     * 
     * @return the jobs.
     */
    public Map<String, Object> getJobs() {
        return jobs;
    }
    
    /**
     * Set the on.
     * 
     * @param on the on.
     */
    public void setOn(On on) {
        this.on = on;
    }
    
    /**
     * Set the name.
     * 
     * @param name the name.
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Set the jobs.
     * 
     * @param jobs the jobs.
     */
    public void setJobs(Map<String, Object> jobs) {
        this.jobs = jobs;
    }
}
