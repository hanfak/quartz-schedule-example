package excuterscheduler;

import org.apache.commons.lang3.time.StopWatch;

import java.util.stream.IntStream;

public class StopWatchExample {
    public static int doSomething() {
        return IntStream.range(1, 3000001)
                .map(x -> x * 2)
                .reduce((first, second) -> second) // Get last element of stream
                .orElse(0);
    }

    public static void main(String[] args) throws InterruptedException {
        StopWatch stopWatch = new StopWatch();

        stopWatch.start();
        Thread.sleep(3001); // Small changes will not be counted
        stopWatch.stop();
        System.out.println("End time is " + stopWatch.getTime());
        stopWatch.reset();

        stopWatch.start();
        int v = StopWatchExample.doSomething();
        System.out.println(v);
        System.out.println("End time is " + stopWatch.getTime());
    }
}
