package me.arley.method;

/**
 * @author wengzi
 * @date 2019/10/23 晚上19:13
 * @description 线程让步 yield()
 */
public class YieldThread extends Thread {

    YieldThread() {

    }

    YieldThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        int i = 0;
        int num = 100;
        for (; i < num; i++) {
            System.out.println(this.getName() + "  " + i);

            //当 i = 20 使用 yield 方法让当前线程同步
            if (i == 20) {
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) {

        //启动两条并发线程
        YieldThread yieldThread1 = new YieldThread("高级");
        //将 "高级" 线程 设置为最高优先级
        yieldThread1.setPriority(Thread.MAX_PRIORITY);
        yieldThread1.start();


        YieldThread yieldThread2 = new YieldThread("低级");
        //将 "低级" 线程 设置为最低优先级
        yieldThread2.setPriority(Thread.MIN_PRIORITY);
        yieldThread2.start();

    }
}
