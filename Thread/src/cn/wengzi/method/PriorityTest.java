package cn.wengzi.method;

/**
 * @author wengzi
 * @date 2019/10/23 night 22:56
 */
public class PriorityTest extends Thread {

    PriorityTest() {

    }

    PriorityTest(String name) {
        super(name);
    }

    @Override
    public void run() {
        int i = 0;
        int num = 50;
        for (; i < num; i++) {
            System.out.println(this.getName() + ",其优先值是:" + this.getPriority() +
                    ",循环变量的值为:" + i);
        }
    }

    public static void main(String[] args) {
        //改变主线程的优先级
        Thread.currentThread().setPriority(6);

        int i = 0;
        int num = 30;
        for (; i < num; i++) {
            if (i == 10) {
                PriorityTest low = new PriorityTest("低级");
                low.start();
                System.out.println("创建之初的优先级:" + low.getPriority());
                //设置该线程为最低优先级
                low.setPriority(Thread.MIN_PRIORITY);
            }
            if (i == 20) {
                PriorityTest high = new PriorityTest("低级");
                high.start();
                System.out.println("创建之初的优先级:" + high.getPriority());
                //设置该线程为最高优先级
                high.setPriority(Thread.MAX_PRIORITY);
            }
        }


    }
}
