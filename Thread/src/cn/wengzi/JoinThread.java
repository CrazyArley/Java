package cn.wengzi;

/**
 * @author wengzi
 * @date 2019/10/23 晚上18:57
 * @description 线程等待 join()
 */
public class JoinThread extends Thread {

    /**
     *  join(): 某个程序执行流中调用其他线程的join方法时,调用线程将被阻塞,知道join方法加入的线程执行完毕
     */

    /**
     * 有参构造,用于设置线程名字
     *
     * @param name 线程名字
     */
    public JoinThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        int i = 0;
        int num = 100;
        for (; i < num; i++) {
            System.out.println(this.getName() + "   " + i);
        }
    }

    public static void main(String[] args) {

        //启动子线程
        new JoinThread("新线程").start();
        int i = 0;
        int num = 100;
        for (; i < num; i++) {

            if (i == 20) {

                //主线程执行到二十,只有当被join的线程执行完成后,才会执行主线程.

                JoinThread joinThread = new JoinThread("被Join的线程");
                joinThread.start();

                try {
                    joinThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println(Thread.currentThread().getName() + "    " + i);
        }

    }
}
