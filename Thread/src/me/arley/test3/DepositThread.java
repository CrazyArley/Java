package me.arley.test3;

/**
 * @author wengzi
 * @date 2019/10/24 afternoon 14:00
 * @description 存钱
 */
public class DepositThread extends Thread {

    private Account account;

    private Double depositAmount;

    public DepositThread() {

    }

    public DepositThread(String name, Account account, Double depositAmount) {
        super(name);
        this.account = account;
        this.depositAmount = depositAmount;
    }

    /**
     * 重复100次存钱操作
     */
    @Override
    public void run() {
        int i = 0;
        int num = 100;
        for (; i < num; i++) {
            account.deposit(depositAmount);
        }
    }
}
