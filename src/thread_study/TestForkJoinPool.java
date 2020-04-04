package thread_study;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

public class TestForkJoinPool {
    public static void main1(String[] args) {
        Instant start = Instant.now();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoinSunCalculate(0L, 50000000000L);
        Long invoke = forkJoinPool.invoke(task);
        System.out.println(invoke);
        Instant end = Instant.now();
        System.out.println(Duration.between(start, end).toMillis()); //8846
    }

    public static void main2(String[] args) {
        Instant start = Instant.now();
        long sum = 0L;
        for (long i = 0; i < 50000000000L; i++) {
            sum += i;
        }
        System.out.println(sum);
        Instant end = Instant.now();
        System.out.println(Duration.between(start, end).toMillis()); //13745
    }

    public static void main(String[] args) {
        Instant start = Instant.now();
        long sum = LongStream.rangeClosed(0L, 50000000000L)
                .parallel()
                .reduce(0L, Long::sum);
        System.out.println(sum);
        Instant end = Instant.now();
        System.out.println(Duration.between(start, end).toMillis()); //5156
    }
}

class ForkJoinSunCalculate extends RecursiveTask<Long> {
    private long start;
    private long end;

    //临界值
    private static final long VALUE = 10000L;

    public ForkJoinSunCalculate(long start, long end){
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long length = end - start;
        if(length <= VALUE){
            long sum = 0L;
            for (long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        }else{
            long middle = (end - start) / 2 + start;
            ForkJoinSunCalculate leftCalculate = new ForkJoinSunCalculate(start, middle);
            leftCalculate.fork(); //进行拆分，同时压入线程队列

            ForkJoinSunCalculate rightCalculate = new ForkJoinSunCalculate(middle + 1, end);
            rightCalculate.fork();//进行拆分，同时压入线程队列

            return leftCalculate.join() + rightCalculate.join();
        }
    }
}