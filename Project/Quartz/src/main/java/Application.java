
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import task.HelloJob;

public class Application {
    public static void main(String[] args) throws SchedulerException {
        // 创建scheduler调度器
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        // 获取调度器上下文信息，并设置键值对
        scheduler.getContext().put("skey", "svalue");

        // 创建触发器
        Trigger trigger = TriggerBuilder
                .newTrigger()
                .withIdentity("trigger1", "group1")
                .usingJobData("t1", "tv1")  // 存储数据
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(3).repeatForever()) // 简单触发器，每3秒执行一次，并永远执行
                .build();

        trigger.getJobDataMap().put("t2", "tv2");

        // 创建Job
        // 定义任务，并绑定到 HelloJob 类
        JobDetail job = JobBuilder.newJob(HelloJob.class)
                .usingJobData("j1", "jv1")
                .withIdentity("job1", "group1").build();

        job.getJobDataMap().put("j2", "jv2");

        // 注册trigger并启动scheduler
        scheduler.scheduleJob(job, trigger);
        scheduler.start();
    }
}
