package me.arley.synchrolock.test3;

import lombok.*;

/**
 * @author wengzi
 * @date 2019/10/24 afternoon 13:42
 * @description 线程的协调运行
 */
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Account {

    @Getter
    @Setter
    private Integer accountNo;
    @Getter
    private Double balance;

    /**
     * 标识账户中是否有存款的旗标
     */
    private Boolean flag = false;


    /**
     * 取钱
     *
     * @param drawAmount 当前线程取出的钱
     */
    public synchronized void draw(Double drawAmount) {
        /* 如果 flag 为true,表示没人存钱进去,则取钱方法阻塞 */
        try {
            if (!flag) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                /* 执行取钱 */
                System.out.println(Thread.currentThread().getName() + "取钱:" + drawAmount);
                balance -= drawAmount;
                System.out.println(Thread.currentThread().getName() + "取钱后,账户余额为:" + balance);

                /* 将标识账户是否已有存款的镖旗设置为false */
                flag = false;

                /* 唤醒其他线程 */
                notifyAll();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 存钱
     *
     * @param depositAmount 当前线程存了多少钱
     */
    public synchronized void deposit(Double depositAmount) {
        try {
            /* 如果 flag 为true,表明已经有人存钱进去,则此方法阻塞 */
            if (flag) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                /* 执行存款 */
                System.out.println(Thread.currentThread().getName() + "存款:" + depositAmount);
                balance += depositAmount;
                System.out.println(Thread.currentThread().getName() + "存款后,账户余额为:" + balance);

                /* 将表示账户是否已有存款的镖旗设置为 true */
                flag = true;

                /* 唤醒其他线程 */
                notifyAll();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
