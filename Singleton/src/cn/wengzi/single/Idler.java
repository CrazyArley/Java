package cn.wengzi.single;

/**
 * @author wengzi
 * @date 2019/10/19 上午11:35
 * @description 懒汉式 单例 实现了延迟加载
 */
public class Idler {

    private Idler() {
    }

    /**
     * 类初始化时,不立即初始化这个对象(延迟加载,真正调用的时候再创建).
     */
    private static Idler instance = null;


    /**
     * 方法同步,调用效率底
     *
     * @return
     */
    public static synchronized Idler getInstance() {
        if (null == instance) {
            instance = new Idler();
        }
        return instance;
    }
}
