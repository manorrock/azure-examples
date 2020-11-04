package gwg.model;

import java.util.List;

/**
 * A GitHub on.
 *
 * @author Manfred Riem (mriem@manorrock.com)
 */
public class On {
    
    /**
     * Stores the push.
     */
    private Push push;
    
    /**
     * Stores the schedule.
     */
    private List<Cron> schedule;
    
    /**
     * Stores the workflow dispatch.
     */
    private WorkflowDispatch workflow_dispatch;
    
    /**
     * Constructor.
     */
    public On() {
        this.workflow_dispatch = new WorkflowDispatch();
    }

    /**
     * Get the push.
     * 
     * @return the push.
     */
    public Push getPush() {
        return push;
    }

    /**
     * Get the schedule.
     * 
     * @return the schedule.
     */
    public List<Cron> getSchedule() {
        return schedule;
    }

    /**
     * Get the workflow dispatch.
     * 
     * @return the workflow dispatch.
     */
    public WorkflowDispatch getWorkflow_dispatch() {
        return workflow_dispatch;
    }

    /**
     * Set the push.
     * 
     * @param push the push.
     */
    public void setPush(Push push) {
        this.push = push;
    }

    /**
     * Set the schedule.
     * 
     * @param schedule the schedule.
     */
    public void setSchedule(List<Cron> schedule) {
        this.schedule = schedule;
    }

    /**
     * Set the workflow dispatch.
     * 
     * @param workflow_dispatch the workflow dispatch.
     */
    public void setWorkflow_dispatch(WorkflowDispatch workflow_dispatch) {
        this.workflow_dispatch = workflow_dispatch;
    }
}
