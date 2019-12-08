package cn.wengzi;

import cn.wengzi.entity.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author leizige
 * @date 19/12/8 AM 11:22
 */
public class PropertiesDistinct {


    public static void main(String[] args) {
        Student s1 = new Student(1L, "张三", 26, "山西");
        Student s2 = new Student(2L, "李四", 24, "上海");
        Student s3 = new Student(3L, "王五", 25, "广州");
        Student s4 = new Student(4L, "赵六", 27, "山西");
        Student s5 = new Student(5L, "孙七", 23, "山西");
        Student s6 = new Student(6L, "张三", 23, "山西");

        List<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        students.add(s5);
        students.add(s6);

        List<Student> list = students.stream().filter(distinctByKey(Student::getAddress)).collect(Collectors.toList());

        list.forEach(System.out::println);

    }

    /**
     * 根据某个属性去重
     *
     * @param keyExtractor
     * @param <T>
     * @return
     */
    public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
        Map<Object, Boolean> seen = new HashMap<>(16);
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }
}
