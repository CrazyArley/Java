package cn.wengzi.annonation;

import cn.wengzi.annonation.interfaces.MyTag;

/**
 * @author wengzi
 * @date 2019/10/20 下午16:04
 */
public class Test {

    /**
     * 使用带成员变量的 Annotation 时,需要为该成员变量赋值
     * 成员变量有默认值,可以不指定
     */
    @MyTag(name = "zs", age = 23)
    public void info() {

    }
}
