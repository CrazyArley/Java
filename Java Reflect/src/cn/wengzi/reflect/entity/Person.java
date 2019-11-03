package cn.wengzi.reflect.entity;

import cn.wengzi.reflect.interfaces.MyInterface;
import cn.wengzi.reflect.interfaces.MyInterface2;


import java.io.Serializable;

public class Person implements Serializable, MyInterface, MyInterface2 {
    private static final long serialVersionUID = 8321704082118626232L;

    private Integer id;
    private String name;
    private Integer age;
    public String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }

    //无参构造
    public Person() {

    }

    //多个参数构造
    public Person(Integer id, String name, Integer age, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    //一个参数构造
    public Person(String name) {
        this.name = name;
    }

    //静态方法
    public static void staticMethod() {
        System.out.println("static Method ...");
    }

    //私有方法
    private void privateMethod() {
        System.out.println("private Method ...");
    }

    //带参数的私有方法
    private void privateMethodParam(String param) {
        System.out.println("private Method ..." + param);
    }


    @Override
    public void InterfaceMethod() {
        System.out.println("Interface Method ...");
    }

    @Override
    public void InterfaceMethod2() {
        System.out.println("Interface Method2 ...");
    }
}
