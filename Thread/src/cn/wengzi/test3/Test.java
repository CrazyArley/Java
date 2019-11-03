package cn.wengzi.test3;

/**
 * @author wengzi
 * @date 2019/10/24 afternoon 14:03
 */
public class Test {
    public static void main(String[] args) {
        //创建一个账户
        Account account = new Account(1, 0.0, false);

        new DrawThread("取钱者", account, 100.0).start();

        new DepositThread("存钱者甲",account,100.0).start();
        new DepositThread("存钱者乙",account,100.0).start();
        new DepositThread("存钱者丙",account,100.0).start();
    }
}
