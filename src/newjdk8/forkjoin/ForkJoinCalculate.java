package newjdk8.forkjoin;

import java.util.concurrent.RecursiveTask;

// 一个并行计算的示例
public class ForkJoinCalculate extends RecursiveTask<Long> {

    private static final long serialVersionUID = -2761358406351641206L;

    public ForkJoinCalculate(long start, long end) {
        this.start = start;
        this.end = end;
    }

    // 范围
    private long start;
    private long end;
    // 临界值
    private static final long THRESHOLD = 10000;

    @Override
    protected Long compute() {
        long length = end - start;
        if(length <= THRESHOLD){
            long sum = 0;
            for (long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        }else{
            // 拆分为子任务
            long mid = (end - start) / 2 + start;
            ForkJoinCalculate calculateLeft = new ForkJoinCalculate(start, mid);
            calculateLeft.fork();

            ForkJoinCalculate calculateRight = new ForkJoinCalculate(mid + 1, end);
            calculateRight.fork();
            return calculateLeft.join() + calculateRight.join();
        }
    }
}
