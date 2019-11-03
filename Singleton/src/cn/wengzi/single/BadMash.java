package cn.wengzi.single;

/**
 * @author wengzi
 * @date 2019/10/19 上午11:27
 * @description 饿汉式 单例
 */
public class BadMash {

    private BadMash() {
    }

    /**
     * 类初始化时,立即初始化这个对象(没有延迟加载的优势).
     * 由于加载类时,天然线程安全.
     */
    private static BadMash instance = new BadMash();

    /**
     * 方法没有同步,调用效率高
     *
     * @return BadMash instance
     */
    public static BadMash getInstance() {
        return instance;
    }
}
