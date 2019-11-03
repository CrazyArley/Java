package cn.wengzi.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wengzi
 * @date 9:56 2019/9/27
 * @Description 流的计数
 */
public class StreamCount {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Hello", "World", "Java");

        long count = list.stream().count();
        System.out.println(count);

        System.out.println("###############");

        Long count1 = list.stream().collect(Collectors.counting());
        System.out.println(count1);
    }
}
