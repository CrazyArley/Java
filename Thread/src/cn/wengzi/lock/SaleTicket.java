package cn.wengzi.lock;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author leizige
 * @date 2020/03/30 night 21:56
 * desc:使用 lock 解决卖票问题
 */
public class SaleTicket {
    public static void main(String[] args) {
        /* 多线程操作 */
        Ticket ticket = new Ticket();

        new Thread(() -> {
            for (int i = 1; i < 50; i++) ticket.sale();
        }, "A").start();
        new Thread(() -> {
            for (int i = 1; i < 50; i++) ticket.sale();
        }, "B").start();
        new Thread(() -> {
            for (int i = 1; i < 50; i++) ticket.sale();
        }, "C").start();

    }
}

/* 资源类 属性和方法 */
class Ticket {

    /* 模拟五十张票 */
    private Integer number = 50;

    Lock lock = new ReentrantLock();

    /* 卖票方法 */
    public void sale() {
        lock.lock();
        try {
            if (number > 0) {
                System.err.println(Thread.currentThread().getName() +
                        "卖出了" + (number--) + "张票!" + ",剩余" + number + "张票");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}