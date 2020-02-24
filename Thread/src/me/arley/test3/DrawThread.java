package me.arley.test3;

/**
 * @author wengzi
 * @date 2019/10/24 afternoon 13:57
 * @description 取钱
 */
public class DrawThread extends Thread {

    private Account account;

    private Double drawAmount;

    public DrawThread() {

    }

    public DrawThread(String name, Account account, Double drawAmount) {
        super(name);
        this.account = account;
        this.drawAmount = drawAmount;
    }

    /**
     * 重复100次取钱操作
     */
    @Override
    public void run() {
        int i = 0;
        int num = 100;
        for (; i < num; i++) {
            account.draw(drawAmount);
        }
    }
}
