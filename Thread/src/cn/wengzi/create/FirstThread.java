package cn.wengzi.create;

/**
 * @author wengzi
 * @date 2019/10/23 下午16:41
 * @description 通过继承 Thread 类来实现线程
 * 使用继承 Thread 类的方法来创建线程,多条线程之间无法共享线程类的实例变量
 */
public class FirstThread extends Thread {


    /**
     * 重写 Run 方法, Run 方法的方法体就是线程执行体
     */
    @Override
    public void run() {
        int i = 0;
        int num = 100;
        for (; i < num; i++) {
            /**
             * 调用 getName() 方法来返回当前线程名,可通过 setName(String name)为线程创建名字.
             * 通过 this 获取当前线程
             */
            System.out.println(this.getName() + "  " + i);
        }
    }

    public static void main(String[] args) {
        int i = 0;
        int num = 100;
        for (; i < num; i++) {
            /**
             * 调用 Thread 类的 currentThread 方法获取当前线程
             * 这个获取的是主线程 main 方法
             */
            System.out.println(Thread.currentThread().getName() + "  " + i);
            if (i == 20) {

                //创建启动 第一条线程
                new FirstThread().start();
                //创建启动 第二条线程
                new FirstThread().start();
            }
        }
    }
}
