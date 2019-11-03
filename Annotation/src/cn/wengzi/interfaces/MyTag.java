package cn.wengzi.interfaces;

import java.lang.annotation.*;

/**
 * @author wengzi
 * @date 2019/10/20 下午15:59
 * @description 自定义注解
 * @Target: 指明该注解可以注解的程序范围
     * ElementType.TYPE 用于类，接口，枚举但不能是注解
     * ElementType.FIELD 作用于字段，包含枚举值
     * ElementType.METHOD 作用于方法，不包含构造方法
     * ElementType.PARAMETER 作用于方法的参数
     * ElementType.CONSTRUCTOR 作用于构造方法
     * ElementType.LOCAL_VERIABLE 作用于本地变量或者catch语句
     * ElementType.ANNOTATION_TYPE 作用于注解
     * ElementType.PACKAGE 作用于包
 * @Document: 指明该注解可以用于生成doc
 * @Inherited: 该注解可以被自动继承
 * @Retention: 指明在什么级别显示该注解
 */
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@Target({ElementType.METHOD})
public @interface MyTag {

    /**
     * 定义两个成员变量的Annotation
     * Annotation中的成员变量以方法的形式定义
     *
     * @return
     */

    String name();

    int age();

    /**
     * 使用 default 为成员变量赋初始值
     *
     * @return
     */
    String address() default "china";
}
