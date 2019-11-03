package cn.wengzi.test2;

/**
 * @author wengzi
 * @date 2019/10/24 afternoon 13:31
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

    @Override
    public void run() {
        //直接调用 account 的 draw 方法进行取钱
        account.draw(drawAmount);
    }
}
