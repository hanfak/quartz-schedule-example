import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.ParseException;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

public class JobScheduler {

    public static void main(String[] args) throws ParseException {

        try {

            // create job
            JobDetail job = JobBuilder.newJob(TestJob.class)
                    .withIdentity("testJob", "testGroup")
                    .build();

            JobDetail job2 = JobBuilder.newJob(TestJob.class)
                    .withIdentity("testJob", "testGroup1")
                    .build();

            // create trigger
            // Cron Trigger
            // Build a trigger that will fire every minute starting now
            CronTrigger cronTrigger = newTrigger()
                    .withIdentity("testTrigger", "testGroup")
                    .withSchedule(cronSchedule("0/10 * * * * ?"))
                    .build();


            // Simple trigger
            // specify the running period of the job
            Trigger simpleTrigger = newTrigger()
                                    .withIdentity("testTrigger2", "testGroup1")
                                    .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                                    .withIntervalInSeconds(15)
                                    .repeatForever())
                                    .build();

            // schedule it
            Scheduler scheduler = new StdSchedulerFactory().getScheduler();
            scheduler.start();
            scheduler.scheduleJob(job2, simpleTrigger);
            scheduler.scheduleJob(job, cronTrigger);

        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

}