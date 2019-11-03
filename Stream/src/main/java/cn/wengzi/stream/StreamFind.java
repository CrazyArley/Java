package cn.wengzi.stream;

import cn.wengzi.stream.entity.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author wengzi
 * @date 10:01 2019/9/27
 * @Description 流的查找
 */
public class StreamFind {
    public static void main(String[] args) {
        //流的查找 Stream 接口提供了两个方法 findFirst 和 findAny。

        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "zs", 23));
        students.add(new Student(2, "ls", 24));
        students.add(new Student(3, "ww", 25));

        //findFirst 方法返回流中的第一个元素的 Optional
        Optional<Student> first = students.stream().findFirst();
        System.out.println(first);

        System.out.println("############");

        //findAny 方法返回流中的某个元素的 Optional
        Optional<Student> any = students.stream().findAny();
        System.out.println(any);
    }
}
