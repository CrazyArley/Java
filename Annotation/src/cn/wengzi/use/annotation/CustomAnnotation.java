package cn.wengzi.use.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.FIELD,ElementType.PARAMETER})
@Documented
@Inherited
@SuppressWarnings("all")
public @interface CustomAnnotation {

    /**
     * 是否为空
     *
     * @return
     */
    boolean isNull() default false;

    /**
     * 最大长度
     *
     * @return
     */
    int maxLength() default 8;

    /**
     * 字段描述
     *
     * @return
     */
    String description() default "";
}
