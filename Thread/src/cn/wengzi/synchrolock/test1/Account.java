package cn.wengzi.synchrolock.test1;

import lombok.*;

/**
 * @author wengzi
 * @date 2019/10/23 night 23:10
 * @description 同步锁 synchronized
 */
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Account {

    @Getter
    @Setter
    private Integer accountNo;
    /**
     * 因为账户余额不能随便修改,所以取消 balance 的setter方法
     */
    @Getter
    private Double balance;


    /**
     * 提供一个线程安全的 draw 方法来完成取钱操作
     *
     * @param drawAmount 当前线程想取到的钱
     */
    public synchronized void draw(Double drawAmount) {
        //账户余额大于取钱数
        if (balance >= drawAmount) {
            //吐出钞票
            System.out.println(Thread.currentThread().getName() + "取钱成功,吐出钞票:" + drawAmount);

            /*try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/

            //修改余额
            balance -= drawAmount;
            System.out.println(Thread.currentThread().getName() + "取钱后,余额为:" + this.balance);
        } else {
            System.out.println(Thread.currentThread().getName() + "取钱失败,余额不足");
        }
    }
}
