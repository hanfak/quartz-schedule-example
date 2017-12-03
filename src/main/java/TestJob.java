
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.time.ZoneId;
import java.time.ZonedDateTime;


public class TestJob implements Job {


    public void execute(JobExecutionContext jExeCtx) throws JobExecutionException {
        // Here will run the code to that is scheduled
        ZonedDateTime fireTime = ZonedDateTime.ofInstant(jExeCtx.getFireTime().toInstant(), ZoneId.systemDefault());
        if (fireTime.getSecond() % 15 == 0) {
            System.out.println("Divisible by 15");
            return;
        }
        System.out.println("Hello " + ZonedDateTime.now());
    }

}
