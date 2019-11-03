package cn.wengzi;

import cn.wengzi.create.FirstThread;

/**
 * @author wengzi
 * @date 2019/10/23 晚上18:56
 */
public class isAlive {
    public static void main(String[] args) {
        FirstThread firstThread = new FirstThread();
        int i = 0;
        int num = 300;
        for (; i < num; i++) {
            System.out.println(Thread.currentThread().getName() + "  " + i);

            if (i == 20) {
                //启动线程
                firstThread.start();

                //判断启动线程之后的 isAlive() 值
                System.err.println(firstThread.isAlive());
            }

            //只有线程处于新建、死亡状态时 isisAlive 会返回false
            //因为 i > 20 已经处于新建状态,所以只可能是死亡状态了
            if (i > 20 && !firstThread.isAlive()) {
                //试图再次启动线程
                //firstThread.start();
            }
        }
    }
}
