package gwg.model;

import java.util.List;

/**
 * A GitHub schedule.
 *
 * @author Manfred Riem (mriem@manorrock.com)
 */
public class Schedule {
    
    /**
     * Stores the paths.
     */
    private List<Cron> cron;

    /**
     * Stores the cron.
     * 
     * @return the cron.
     */
    public List<Cron> getCron() {
        return cron;
    }

    /**
     * Set the cron.
     * 
     * @param cron the cron.
     */
    public void setCron(List<Cron> cron) {
        this.cron = cron;
    }
}
