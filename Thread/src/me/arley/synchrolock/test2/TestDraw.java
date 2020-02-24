package me.arley.synchrolock.test2;

/**
 * @author wengzi
 * @date 2019/10/24 afternoon 13:33
 */
public class TestDraw {
    public static void main(String[] args) {
        Account account = new Account(1, 100.0);

        new DrawThread("zs", account, 20.0).start();
        new DrawThread("ls", account, 40.0).start();
    }
}
