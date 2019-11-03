package cn.wengzi.stream;

import java.util.stream.Stream;

/**
 * @author wengzi
 * @date 10:06 2019/9/27
 * @Description 流的匹配
 */
public class StreamMatch {
    public static void main(String[] args) {
        //流的匹配 Stream 接口提供了三个方法:anyMatch,allMatch,noneMatch


        //anyMatch:任何一个元素匹配,返回true
        boolean b = Stream.of(1, 2, 3, 4, 6, 7).anyMatch(x -> x > 5);
        System.out.println(b);

        System.out.println("##################");

        //allMatch:所有元素匹配,返回true
        boolean b1 = Stream.of(1, 2, 3, 4, 6, 7).allMatch(x -> x > 0);
        System.out.println(b1);

        System.out.println("##################");

        //noneMatch:没有一个元素匹配,返回true
        boolean b3 = Stream.of(1, 2, 3, 4, 6, 7).noneMatch(x -> x > 7);
        System.out.println(b3);
    }
}
