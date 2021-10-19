package task;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerException;

public class HelloJob implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        Object sv = null;
        try {
            sv = context.getScheduler().getContext().get("skey");
        } catch (SchedulerException e) {
            e.printStackTrace();
        }

        System.out.println("scheduler: " + sv);

        Object tv1 = context.getTrigger().getJobDataMap().get("t1");
        Object tv2 = context.getTrigger().getJobDataMap().get("t2");

        Object jv1 = context.getJobDetail().getJobDataMap().get("j1");
        Object jv2 = context.getJobDetail().getJobDataMap().get("j2");

        System.out.println("trigger: " + tv1);
        System.out.println("trigger: " + tv2);
        System.out.println("job: " + jv1);
        System.out.println("job: " + jv2);
        System.out.println("===============");
    }

}
