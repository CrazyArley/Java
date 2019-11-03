package test;

import Iinterfaces.LambdaNoneReturnMultiParameter;
import Iinterfaces.LambdaNoneReturnSingleParameter;
import Iinterfaces.LambdaSingleReturnNoneParameter;

public class syntax_two {
    public static void main(String[] args) {
        //语法精简
        //1.参数
        //由于再接口的抽象方法中，已经定义了参数的数量和类型，所以在Lambda中参数的类型可以省略
        //注意：如果需要省参数类型，则每一个参数的类型都要省略;
        LambdaNoneReturnMultiParameter lambda1 = (a,b)->{
            System.out.println();
        };
        //2.参数小括号
        //如果参数列表中，参数的数量只有一个，此时小括号可以省略
        LambdaNoneReturnSingleParameter lambda2 = a -> {
            System.out.println(a);
        };
        //3.方法大括号
        //如果方法体中只有一条语句，大括号可以省略
        LambdaNoneReturnSingleParameter lambda3 = a -> System.out.println(a);
        //4.如果方法体中唯一的一条语句是一个返回语句,则在省略掉大括号的同时，需要把return去掉
        LambdaSingleReturnNoneParameter lambda4 = () ->  10;
    }
}
