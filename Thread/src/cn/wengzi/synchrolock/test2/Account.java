package cn.wengzi.synchrolock.test2;

import lombok.*;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wengzi
 * @date 2019/10/24 afternoon 13:19
 * @description 同步锁 lock
 */
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Account {

    /**
     * 定义锁对象
     */
    private final ReentrantLock lock = new ReentrantLock();

    @Getter
    @Setter
    private Integer accountNo;
    @Getter
    private Double balance;

    /**
     * 提供一个线程安全的 draw 方法来完成取钱操作
     *
     * @param drawAmount 当前线程要去的钱
     */
    public void draw(Double drawAmount) {

        //对同步锁进行加锁
        lock.lock();

        try {
            if (balance >= drawAmount) {
                System.out.println(Thread.currentThread().getName() + "取钱成功,吐出钞票" + drawAmount);

                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //修改余额
                balance -= drawAmount;
                System.out.println(Thread.currentThread().getName() + "取钱成功,余额为:" + balance);

            } else {
                System.out.println(Thread.currentThread().getName() + "取钱失败,余额不足");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //使用 finally 来确保释放锁
            //线程每次调用 lock() 加锁后,必须显式调用 unlock 来释放锁
            lock.unlock();
        }

    }

}
