package cn.wengzi.test1;

/**
 * @author wengzi
 * @date 2019/10/23 night 23:29
 * @description 线程安全, 模拟银行取钱
 */
public class DrawThread extends Thread {


    /**
     * 模拟账户余额
     */
    private Account account;
    /**
     * 当前线程想取到的钱
     */
    private Double drawAmount;

    public DrawThread() {

    }

    public DrawThread(String name, Account account, Double drawAmount) {
        super(name);
        this.account = account;
        this.drawAmount = drawAmount;
    }

    /**
     * 多个线程修改同一个共享数据时,将涉及数据安全问题
     */
    @Override
    public void run() {

        //账户余额大于取钱数量
        /*if (account.getBalance() >= drawAmount) {

            System.out.println(this.getName() + "取钱成功,吐出钞票:" + drawAmount);

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //修改余额
            account.setBalance(account.getBalance() - drawAmount);
            System.out.println(this.getName() + "取钱后,余额为:" + account.getBalance());
        } else {
            System.out.println(this.getName() + "取钱失败,余额不足");
        }*/

        /**
         * 使用 account 为同步监视器,任何线程再进去以下代码块之前,
         * 必须先对 account 账户锁定 --- 其他线程无法获得锁,也就无法修改
         * 此做法: 加锁 -> 修改完成 -> 释放锁 逻辑
         */
        /*synchronized (account) {
            //账户余额大于取钱数量
            if (account.getBalance() >= drawAmount) {

                System.out.println(this.getName() + "取钱成功,吐出钞票:" + drawAmount);

                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //修改余额
                Double balance = account.getBalance();
                balance -= drawAmount;
                System.out.println(this.getName() + "取钱后,余额为:" + account.getBalance());
            } else {
                System.out.println(this.getName() + "取钱失败,余额不足");
            }
        }*/

        //直接调用 account 的 draw 方法进行取钱
        account.draw(drawAmount);
    }
}
