package com.arley;

/**
 * @author Arley
 * desc:测试泛型
 */
@SuppressWarnings("all")
public class Test {
    public static void main(String[] args) {

        /**
         * 泛型的类型参数只能是类类型(包括自定义类),不能是基本类型
         * 传入的实参类型与泛型的类型参数类型相同,即为Integer
         */
        Generic<Integer> integerGeneric = new Generic<>(666666);

        /**
         * 传入的实参类型与泛型的类型参数类型相同,即为String
         */
        Generic<String> stringGeneric = new Generic<>("key");

        /**
         * 定义的泛型类，并不以一定非得传入泛型类型实参！
         */
        Generic generic1 = new Generic(666666);
        Generic generic2 = new Generic("666666");
        Generic generic3 = new Generic(666666L);
        Generic generic4 = new Generic(true);

    }
}
