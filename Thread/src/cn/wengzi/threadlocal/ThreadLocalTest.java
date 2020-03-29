package cn.wengzi.threadlocal;

/**
 * @author Arley
 * @email qx_leizige@163.com
 * @desc ThreadLocal 使用示例
 */
public class ThreadLocalTest {

    /* 1) 创建 ThreadLocal 变量*/
    static ThreadLocal<String> localVariable = new ThreadLocal<>();

    /**
     * 2) 打印print函数
     *  2.1) 打印当前本地内存中 localVariable 变量的值
     *  2.2) 清除当前线本地内存中的 localVariable 变量
     */
    static void print(String str) {
        System.out.println(str + ":" + localVariable.get());
        localVariable.remove();
    }

    public static void main(String[] args) {

        /* 3) 创建线程One */
        Thread threadOne = new Thread(() -> {
            /* 3.1) 设置线程One本地变量localVariable的值 */
            localVariable.set("threadOne local variable");
            /* 3.2) 调用打印函数 */
            print("threadOne");
            /* 3.3) 打印本地变量 */
            System.out.println("threadOne remove after" + ":" + localVariable.get());
        });

        /* 4) 创建线程Two */
        Thread threadTwo = new Thread(() -> {
            /* 4.1) 设置线程Two本地变量localVariable的值 */
            localVariable.set("threadTwo local variable");
            /* 4.2) 调用打印函数 */
            print("threadTwo");
            /* 4.3) 打印本地变量 */
            System.out.println("threadTwo remove after" + ":" + localVariable.get());
        });

        /* 5) 启动线程*/
        threadOne.start();
        threadTwo.start();
    }
}
