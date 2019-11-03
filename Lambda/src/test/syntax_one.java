package test;

import Iinterfaces.*;

public class syntax_one {
    public static void main(String[] args) {
        //1.Lambda的基础语法
        //Lambda是一个匿名函数
        //返回值类型  方法名  参数列表  方法体  ：在Lambda中返回值类型不需要显式的表示出来

        //  ():用来描述参数列表
        //  {}：用来描述方法体
        //  ->：Lambda运算符  goes to

        //无参无返回值
        LambdaNoneReturnNoneParameter lambda1 = ()->{
            System.out.println("无参无返回...");
        };
        lambda1.test();

        //无返回值，有一个参数
        LambdaNoneReturnSingleParameter lambda2 = (int a)->{
            System.out.println("无返回值，有一个参数..."+a);
        };
        lambda2.test(2);

        //无返回值，有多个参数
        LambdaNoneReturnMultiParameter lambda3 = (int a,int b) -> {
            System.out.println(a + b);
        };
        lambda3.test(10,10);

        //有返回值，无参数
        LambdaSingleReturnNoneParameter lambda4 = () ->{
            return 10;
        };
        int result1 = lambda4.test();
        System.out.println(result1);

        //有返回值，有一个参数
        LambdaSingleReturnSingleParameter lambda5 = (int a) -> {
            return a * 2;
        };
        int result2 = lambda5.test(2);
        System.out.println(result2);

        //有返回值，有多个参数
        LambdaSingleReturnMultiParameter lambda6 = (int a,int b) -> {
            return a * b;
        };
        int result3 = lambda6.test(2, 2);
        System.out.println(result3);
    }
}
