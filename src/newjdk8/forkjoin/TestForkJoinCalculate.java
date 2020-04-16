package newjdk8.forkjoin;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

public class TestForkJoinCalculate {
    public static void main(String[] args) {
        long n = 50000000000L;
        forkJoinTest(n); //8723
        oneThreadCalc(n); //14337
        streamCalc(n); //4375
    }

    private static void streamCalc(long n) {
        Instant start = Instant.now();
        long reduce = LongStream.range(0, n)
                .parallel()
                .reduce(0, Long::sum);
        System.out.println(reduce);
        Instant end = Instant.now();
        System.out.println("Stream 耗费时间：" + Duration.between(start, end).toMillis() + "毫秒");
    }

    private static void oneThreadCalc(long n) {
        Instant start = Instant.now();
        long sum = 0L;
        for (long i = 0; i <= n; i++) {
            sum += i;
        }
        System.out.println(sum);
        Instant end = Instant.now();
        System.out.println("单线程 耗费时间：" + Duration.between(start, end).toMillis() + "毫秒");
    }

    private static void forkJoinTest(long n) {
        Instant start = Instant.now();
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Long> forkJoinTask = new ForkJoinCalculate(0, n);
        Long sum = pool.invoke(forkJoinTask);
        System.out.println(sum);
        Instant end = Instant.now();
        System.out.println("Fork/Join 耗费时间：" + Duration.between(start, end).toMillis() + "毫秒");
    }
}
