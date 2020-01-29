package com.arley;

import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * @author Arley
 * desc:2020/1/29
 */
public class CalculatorSumTask extends RecursiveTask<Long> {

    private long start;
    private long end;
    //阈值,即结束 for 的条件
    private static final long THRESHOLD = 10000L;

    public CalculatorSumTask(long start, long end) {
        this.start = start;
        this.end = end;
    }

    /**
     * 求 start - end 之间的所有数的和
     *
     * @return Long
     */
    @Override
    protected Long compute() {
        //数的间隔
        long length = end - start;
        long sum = 0L;

        //任务足够小或者不可分
        if (length <= THRESHOLD) {
            //顺序执行该任务
            for (long i = start; i <= end; i++) {
                sum = sum + i;
            }
            return sum;
        } else {
            long middle = (start + end) / 2;
            //将任务拆分成两个子任务
            CalculatorSumTask leftTask = new CalculatorSumTask(start, middle);
            leftTask.fork();
            CalculatorSumTask rightTask = new CalculatorSumTask(middle + 1, end);
            rightTask.fork();

            //fork完成之后将子任务合并
            return leftTask.join() + rightTask.join();
        }
    }

    public static void main(String[] args) {
        long start = Instant.now().toEpochMilli();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Long sum = forkJoinPool.invoke(new CalculatorSumTask(0, 100000000L));
        long end = Instant.now().toEpochMilli();

        System.out.println(sum);

        System.out.println("Fork/Join 并行执行 耗费时间 :" + (end - start) + "ms");
    }

}
