package me.arley;

/**
 * @author wengzi
 * @date 2019/11/6 night 17:48
 * @description 线程死锁
 * <p>
 *     Thread-0是线程A,Thread-1是线程B
 *     线程调度器先调用了线程A,线程A使用Synchronized(resourceA)获取到了resourceA的监视器锁,调用sleep(1000)函数休眠1s
 *     休眠1s是保证线程A在获取resourceB对应的锁前让线程B抢占到cpu,获取到资源resourceB上的锁。
 *     线程A调用sleep(1000)后会执行Synchronized(resourceB)方法,这代表线程B获取到了resourceB对象的监视器锁资源,
 *     然后调用sleep(1000)函数休眠1s。
 *     <li>
 *         因此,线程A获取到resourceA资源,线程B获取到了resourceB资源。
 *         线程A休眠后企图获取resourceB的资源,而resourceB的资源被线程B所持有,所以线程A会被阻塞而等待,
 *         同时线程B休眠后企图获取resourceA的资源,而resourceA的资源被线程A所持有,
 *         所以线程A和线程B就陷入了互相等待的状态,也就产生了死锁。
 *     </li>
 *     <li>
 *         线程A持有ObjectA的资源并等待获取ObjectB的资源,而线程B持有ObjectB的资源并等待获取ObjectA的资源
 *         这构成了环路等待条件,所以线程A和线程B就进入了死锁状态.
 *     </li>
 * </p>
 */
public class DeadLockTest {

    /**
     * 创建资源
     */
    private static Object resourceA = new Object();
    private static Object resourceB = new Object();

    /**
     * 创建线程A
     */
     Thread threadA = new Thread(new Runnable() {
        @Override
        public void run() {
            synchronized (resourceA) {
                System.out.println(Thread.currentThread().getName() + "  " + "get resourceA");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "  " + "waiting get sourceB");
                synchronized (resourceB) {
                    System.out.println(Thread.currentThread().getName() + "  " + "get sourceB");
                }
            }
        }
    });

    /**
     * 创建线程B
     */
     Thread threadB = new Thread(new Runnable() {
        @Override
        public void run() {
            synchronized (resourceB) {
                System.out.println(Thread.currentThread().getName() + "  " + "get resourceB");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "  " + "waiting get sourceA");
                synchronized (resourceA) {
                    System.out.println(Thread.currentThread().getName() + "  " + "get sourceA");
                }
            }
        }
    });

    public static void main(String[] args) {
        DeadLockTest deadLockTest = new DeadLockTest();
        deadLockTest.threadA.start();
        deadLockTest.threadB.start();
    }
}

