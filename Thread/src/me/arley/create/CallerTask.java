package me.arley.create;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author wengzi
 * @date 2019/11/6 afternoon 17:09
 * @description 使用 future task 方式创建线程,可以拿到任务的返回值
 */
public class CallerTask implements Callable<String> {

    /* 创建任务类,类似于Runnable */

    @Override
    public String call() throws Exception {
        return "Hello";
    }

    public static void main(String[] args) {
        //创建异步任务
        FutureTask<String> futureTask = new FutureTask<String>(new CallerTask());

        new Thread(futureTask).start();

        try {
            //等待任务执行完毕,并返回结果
            String result = futureTask.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
