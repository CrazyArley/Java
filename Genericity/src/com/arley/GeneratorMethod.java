package com.arley;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Arley
 * desc:泛型方法
 */
@Slf4j
@SuppressWarnings("all")
public class GeneratorMethod {

    /**
     * @param Clazz 传入的泛型实参
     * @return 返回值为 T 类型
     * @throws InstantiationException
     * @throws IllegalAccessException
     * desc:
     *  1): public 与返回值中间 <T> 非常重要,可以理解为声明此方法为泛型方法
     *  2): 只有声明了 <T> 的方法才是泛型方法,泛型类中使用了泛型的成员方法不是泛型方法
     *  3): <T> 表明该方法将使用泛型类型 T,此时才可以在泛型方法中使用 T
     *  4): 与泛型类的定义一样,此处 T 可以随便写为任何标识
     */
    public <T> T genericMethod(Class<T> Clazz){
        T  instance = null;
        try {
            instance = Clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return instance;
    }

    /**
     * 泛型方法
     * @param args 参数可变
     */
    public static <T> void pringMsg(T... args){
        for (T arg : args) {
            System.out.print(arg);
        }
    }

    public static void main(String[] args) {
        pringMsg("11","22","33");
        pringMsg(11,22,33);
        pringMsg(1.1,2.2,3.3);
    }
}
