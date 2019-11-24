package cn.wengzi;

import cn.wengzi.entity.Student;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author leizige
 * @date 19/11/24 16:11 PM
 */
public class TestStream {

    /**
     * 集合筛选 (Filter)
     *
     * @param students
     */
    public static List<Student> filterTest(List<Student> students) {
        //筛选年龄大于十五岁的学生
        return students.stream().filter(student -> student.getAge() > 24).collect(Collectors.toList());
        /* 筛选住址在上海的学生 */
        // students.stream().filter(student -> "北京".equals(student.getAddress())).collect(Collectors.toList());
    }

    /**
     * 集合转换
     *
     * @param students
     */
    public static List<String> listToMap(List<Student> students) {
        //在地址面前加上部分信息,只获取地址输出
        return students.stream().map(student -> "住址:" + student.getAddress()).collect(Collectors.toList());
    }

    /**
     * 集合去重(基本类型)
     */
    public static void districtOne() {
        //简单字符串去重
        List<String> strings = Arrays.asList("111", "222", "333", "111", "222");
        strings.stream().distinct().forEach(System.err::println);
    }

    /**
     * 集合去重(引用对象)
     */
    public static void districtTwo(List<Student> students) {
        //引用对象去重,引用对象需要重写HashCode和equals方法,否则去重无效
        students.stream().distinct().forEach(System.err::println);
    }

    /**
     * 集合排序(制定规则排序)
     */
    public static void sorted(List<Student> students) {
        //去除重复元素后排序,o2-o1 倒序,o1-o2 升序. Long.compare() o1 在前:升序; o2 在前:降序;
        //students.stream().distinct().sorted((o1, o2) -> o2.getId().intValue() - o1.getId().intValue()).forEach(System.err::println);
        //students.stream().distinct().sorted((o1, o2) -> Long.compare(o1.getId(), o2.getAge())).forEach(System.err::println);
        //去除重复元素后 先根据学生id降序排序,再根据学生年龄降序排序
        students.stream().distinct().
                sorted((o1, o2) -> Long.compare(o2.getId(), o1.getId()))
                .sorted((o1, o2) -> Integer.compare(o2.getAge(), o1.getAge()))
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    /**
     * limit(限制返回个数)
     */
    public static void limit(List<Student> students) {
        students.stream().distinct().
                sorted((o1, o2) -> Long.compare(o2.getId(), o1.getId()))
                .limit(2)
                .forEach(System.err::println);
    }

    /**
     * 集合skip,删除前 n 个元素(包括n)
     */
    public static void skip(List<Student> students) {
        students.stream().distinct().
                sorted((o1, o2) -> Long.compare(o2.getId(), o1.getId()))
                .skip(2)
                .forEach(System.out::println);
    }

    /**
     * Max和Min
     */
    public static void minOrMax(List<Student> students) {
        //找出集合中年龄最大和最小的学生
        Student min = students.stream().distinct().min((o1, o2) -> Integer.compare(o1.getAge(), o2.getAge())).get();
        System.err.println("年龄最小的学生:" + min.getName() + "--" + min.getAge());
        Student max = students.stream().distinct().max((o1, o2) -> Integer.compare(o1.getAge(), o2.getAge())).get();
        System.err.println("年龄最大的学生:" + max.getName() + "--" + max.getAge());
    }

    public static void main(String[] args) {
        Student s1 = new Student(1L, "张三", 26, "山西");
        Student s2 = new Student(2L, "李四", 24, "上海");
        Student s3 = new Student(3L, "王五", 25, "广州");
        Student s4 = new Student(4L, "赵六", 27, "北京");
        Student s5 = new Student(5L, "孙七", 23, "浙江");
        Student s6 = new Student(6L, "张三", 23, "山西");

        List<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        students.add(s5);

        students.forEach(System.out::println);

        System.out.println("/------------------------------------/");

        List<Student> filterStudent = filterTest(students);
        filterStudent.forEach(student -> System.err.println(student.getAge() + "  " + student.getName()));

        System.out.println("/------------------------------------/");

        List<String> list = listToMap(students);
        list.forEach(s -> System.out.println(s));

        System.out.println("/------------------------------------/");

        districtOne();

        System.out.println("/------------------------------------/");


        districtTwo(students);

        System.out.println("/------------------------------------/");

        sorted(students);

        System.out.println("/------------------------------------/");

        limit(students);

        System.out.println("/------------------------------------/");

        skip(students);

        System.out.println("/------------------------------------/");


        minOrMax(students);
    }
}
