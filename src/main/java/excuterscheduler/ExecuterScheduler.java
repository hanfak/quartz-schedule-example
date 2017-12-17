package excuterscheduler;

import java.util.concurrent.*;

public class ExecuterScheduler {
    private static ScheduledExecutorService scheduledExecutorService =
            Executors.newScheduledThreadPool(1);

    public static ScheduledFuture<?> schedulerExecuteFixedDelay() {
        return scheduledExecutorService.scheduleAtFixedRate(ExecuterScheduler::exampleCallable,
                0,
                3,
                TimeUnit.SECONDS);
    }

    private static String exampleCallable() {
        System.out.println("Executed!");
        return "Called!";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecuterScheduler.schedulerExecuteFixedDelay();
    }
}
