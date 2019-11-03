package cn.wengzi.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author wengzi
 * @date 9:30 2019/9/27
 * @Description 流的创建
 */
public class TestCreateStream {
    public static void main(String[] args) {
        //利用Stream.of方法创建流
        Stream<String> stream = Stream.of("hello", "world", "Java8");
        stream.forEach(System.out::println);
        System.out.println("##################");
        //利用Stream.iterate方法创建流
        Stream.iterate(10, n -> n + 1)
                .limit(5)
                .collect(Collectors.toList())
                .forEach(System.out::println);
        System.out.println("##################");
        //利用Stream.generate方法创建流
        Stream.generate(Math::random).limit(5).forEach(System.out::println);
        System.out.println("##################");
        //从现有的集合中创建流
        List<String> strings = Arrays.asList("hello", "world", "Java8");
        String string = strings.stream().collect(Collectors.joining(","));
        System.out.println(string);
    }

}
