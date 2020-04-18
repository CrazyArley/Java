package cn.wengzi.synchrolock;


/**
 * @author leizige
 * @date 2020/03/30 night 21:56
 * desc:使用 synchronized 解决卖票问题
 */
public class SaleTicket {
    public static void main(String[] args) {
        /* 多线程操作 */

        Ticket ticket = new Ticket();

        new Thread(() -> {
            for (int i = 1; i < 50; i++) {
                ticket.sale();
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 1; i < 50; i++) {
                ticket.sale();
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 1; i < 50; i++) {
                ticket.sale();
            }
        }, "C").start();

    }
}

/* 资源类 属性和方法 */
class Ticket {

    /* 模拟五十张票 */
    private Integer number = 50;

    /* 卖票方法 */
    public synchronized void sale() {
        if (number > 0) {
            System.err.println(Thread.currentThread().getName() +
                    "卖出了" + (number--) + "张票!" + ",剩余" + number + "张票");
        }
    }
}