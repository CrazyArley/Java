package com.arley;

/**
 * @author Arley
 * date:2020/02/10 forenoon 10:54
 * desc:静态方法泛型
 */
@SuppressWarnings("all")
public class StaticGenerator<T> {

    /**
     * 如果在类中定义使用泛型的静态方法,需要将这个方法定义为泛型方法
     * 即使静态方法中要使用泛型类中已经声明过的泛型也不可以
     * 如:
     *      public static void test(T t)
     *      此时会编译错误！
     * @param t
     * @param <T>
     */
    public static <T> void test(T t) {
        System.out.println(t.toString());
    }
}
