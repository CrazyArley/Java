package exercise;

import pojo.Person;

import java.util.ArrayList;

public class Exercise_one {
    //集合排序(降序)
    //ArrayList<>
    public static void main(String[] args) {
        ArrayList<Person> lists = new ArrayList<>();

        lists.add(new Person("ls",6));
        lists.add(new Person("zl",26));
        lists.add(new Person("zs",23));
        lists.add(new Person("ww",25));
        lists.add(new Person("ls",24));
        lists.add(new Person("zs",10));
        lists.add(new Person("ww",9));


        lists.sort((o1, o2) -> o2.age - o1.age);

        System.out.println(lists);
    }
}
