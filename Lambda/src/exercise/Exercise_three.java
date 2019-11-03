package exercise;

import pojo.Person;

import java.util.ArrayList;

public class Exercise_three {
    public static void main(String[] args) {
        //删除集合中满足条件的元素
        ArrayList<Person> lists = new ArrayList<>();

        lists.add(new Person("ls",6));
        lists.add(new Person("zl",26));
        lists.add(new Person("zs",23));
        lists.add(new Person("ww",25));
        lists.add(new Person("ls",24));
        lists.add(new Person("zs",10));
        lists.add(new Person("ww",9));

        //Lambda实现
        //将集合中的每一个元素都带入test方法中，如果返回值为true，则删除这个元素
        lists.removeIf(person -> person.age > 10);

        System.out.println(lists);
    }
}
