package cn.wengzi.create;


/**
 * @author wengzi
 * @date 2019/10/23 下午17:49
 * @description 通过实现 Runnable 接口来实现线程
 */
public class SecondThread implements Runnable {
    @Override
    public void run() {
        int i = 0;
        int num = 100;
        for (; i < num; i++) {
            /**
             * 当线程类实现 Runnable 接口时候
             * 如果想要获取当前线程,只能通过 Thread.currentThread 方法
             */
            System.out.println(Thread.currentThread().getName() + "  " + i);
        }

    }


    public static void main(String[] args) {
        int num = 100;
        for (int i = 0; i <= num; i++) {
            System.out.println(Thread.currentThread().getName() + "   " + i);
            if (i == 20) {
                //主线程 main 方法
                SecondThread secondThread = new SecondThread();

                //通过 Thread(Target,name) 方法创建线程
                new Thread(secondThread, "线程1").start();
                new Thread(secondThread, "线程2").start();
            }
        }
    }
}
