package com.arley;

import com.arley.model.Apple;
import com.arley.model.Fruit;
import com.arley.model.Person;

/**
 * @author Arley
 * date: 2020/02/09 night 20:56
 * desc: 泛型类
 */
@SuppressWarnings("all")
public class Generic<T> {

    /* key这个成员变量的类型为T,T的类型由外部指定 */
    private T key;

    public Generic() {

    }

    /* 泛型构造方法形参key的类型也为T,T的类型由外部指定 */
    public Generic(T key) {
        this.key = key;
    }

    /* 泛型方法getKey的返回值类型为T,T的类型由外部指定 */
    public T getKey() {
        return key;
    }
}

/**
 * @author Arley
 * desc:泛型类中的泛型方法
 */
@SuppressWarnings("all")
class Generic2<T> {

    /**
     * 这里的 T 只能是泛型类实参或者实参的子类
     *
     * @param t
     */
    public void test1(T t) {
        System.out.println(t.toString());
    }

    /**
     * 在泛型类中使用泛型方法,使用泛型 <E>,这种泛型可以为任意类型,可以与泛型类中的声明 T 不是同一种类型
     * 由于泛型方法在声明的时候会声明泛型 <E>,因此即使在泛型类中并未声明泛型,编译器也会正确识别泛型方法中的类型
     *
     * @param t
     * @param <E>
     */
    public <E> void test2(E t) {
        System.out.println(t.toString());
    }

    /**
     * 在泛型类中声明一个泛型方法,使用泛型 <T>
     * 注意这个泛型 <T> 是一个全新的类型,可以与泛型类中声明的 <T> 不是一个类型
     *
     * @param t
     * @param <T>
     */
    public <T> void test3(T t) {
        System.out.println(t.toString());
    }

    public static void main(String[] args) {
        Fruit fruit = new Fruit();
        Apple apple = new Apple();
        Person person = new Person();

        Generic2<Fruit> generic2 = new Generic2<>();

        /* apple是 Fruit 的子类,这里编译通过*/
        generic2.test1(fruit);
        generic2.test1(apple);

        /* 泛型指定实参为 Fruit,这里传入 Person 编译不通过*/
        //generic2.test1(person);

        /* 使用这个方法两个都可编译通过 */
        generic2.test2(apple);
        generic2.test2(person);

        /* 使用这个方法两个都可编译通过 */
        generic2.test3(apple);
        generic2.test3(person);
    }
}

/**
 * @author Arley
 * desc:泛型的上边界通配符
 */
@SuppressWarnings("all")
class Generic3<T> {
    //class Generic3<T extends Number>

    private T key;

    public Generic3() {

    }

    public Generic3(T key) {
        this.key = key;
    }

    public T getKey() {
        return key;
    }

    /**
     * 为泛型方法添加上边界通配符,传入实参必须是Number的子类
     * @param obj
     */
    public static void test(Generic3<? extends Number> obj) {
        System.out.println(obj.getKey());
    }

    /**
     * 在泛型方法中添加上边界通配符限制的时候,必须在权限声明与返回值之间的<T>上添加上下边界,即在泛型声明的时候添加
     * 如：
     *      public <T> T showKeyName(Generic<T extends Number> container)
     *      这样编译会报错
     */
    public <T extends Number> T test2(Generic3<T> t){
        return t.getKey();
    }

    public static void main(String[] args) {
        Generic3<String> generic1 = new Generic3("11");
        Generic3<Integer> generic2 = new Generic3(11);
        Generic3<Long> generic3 = new Generic3(11L);
        Generic3<Float> generic4 = new Generic3(11F);
        Generic3<Double> generic5 = new Generic3(1.1);

        /* 因为 String 不是 Number 的子类,这行代码编译错误*/
        //test(generic1);
        test(generic2);
        test(generic3);
        test(generic4);
        test(generic5);
    }
}

/**
 * @author Arley
 * desc:泛型的下边界通配符
 */
@SuppressWarnings("all")
class Generic4<T> {
    //class Generic4<T super Number>

    private T key;

    public Generic4() {

    }

    public Generic4(T key) {
        this.key = key;
    }

    public T getKey() {
        return key;
    }

    /**
     * 为泛型方法添加下边界通配符,传入实参必须是Apple的父类,直至Object
     * @param obj
     */
    public static void test(Generic4<? super Apple> obj) {
        System.out.println(obj.getKey());
    }

    public static void main(String[] args) {
        Object obj = new Object();
        Fruit fruit = new Fruit();
        Apple apple = new Apple();
        Person person = new Person();
        Generic4<Object> generic1 = new Generic4<>(obj);
        Generic4<Fruit> generic2 = new Generic4(fruit);
        Generic4<Apple> generic3 = new Generic4(apple);
        Generic4<Person> generic4 = new Generic4(person);

        /* Object Fruit 是Apple父类*/
        test(generic1);
        test(generic2);
        test(generic3);

        /* Person 不是 Apple 的父类,编译不通过*/
        //test(generic4);
    }
}
