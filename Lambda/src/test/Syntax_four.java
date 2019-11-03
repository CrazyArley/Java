package test;

import pojo.Person;

public class Syntax_four {
    public static void main(String[] args) {

        PersonOne p1 = () ->  new Person();

        //无参构造方法引用
        PersonOne p2 = Person::new;
        p2.getPerson();

        //有参构造方法引用
        PersonTwo p3 = Person::new;
        p3.getPerson("zs",23);

    }
}
@FunctionalInterface
interface PersonOne{
    Person getPerson();
}
@FunctionalInterface
interface PersonTwo{
    Person getPerson(String name,int age);
}
