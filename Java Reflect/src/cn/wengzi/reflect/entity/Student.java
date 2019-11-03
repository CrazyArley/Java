package cn.wengzi.reflect.entity;

public class Student {

    private String name;
    private Integer score;

    @Override
    public String toString() {
        return "Student [name=" + name + ", score=" + score + "]";
    }


    public void Hello() {
        System.out.println("Hello Reflect");
    }
}
