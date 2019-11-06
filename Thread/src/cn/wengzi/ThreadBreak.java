package cn.wengzi;

/**
 * @author wengzi
 * @date 2019/11/6 afternoon 17:21
 * @description 中断线程, 使用 Interrupted 优雅退出线程
 */
public class ThreadBreak extends Thread {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                /* 当前线程中断则退出循环 */
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println(Thread.currentThread() + "Hello");
                }
            }
        });

        thread.start();

        //主线程休眠1s,以便中断前让子线程输出
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //中断子线程
        System.out.println("main thread interrupt thread");
        thread.interrupt();

        try {
            //等待子线程执行完毕
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main is over");
    }
}
