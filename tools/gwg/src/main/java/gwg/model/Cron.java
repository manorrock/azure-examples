package gwg.model;

/**
 * A GitHub cron schedule.
 *
 * @author Manfred Riem (mriem@manorrock.com)
 */
public class Cron {
    
    /**
     * Get the cron.
     */
    private String cron;

    /**
     * Constructor.
     */
    public Cron() {
    }

    /**
     * Constructor.
     * 
     * @param cron the cron.
     */
    public Cron(String cron) {
        this.cron = cron;
    }

    /**
     * Get the cron.
     * 
     * @return the cron.
     */
    public String getCron() {
        return cron;
    }

    /**
     * Set the cron.
     * 
     * @param cron the cron.
     */
    public void setCron(String cron) {
        this.cron = cron;
    }
}
