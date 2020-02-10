package com.arley;

/**
 * 未传入泛型实参时，与泛型类的定义相同，在声明类的时候，需将泛型的声明也一起加到类中
 * 即：class FruitGenerator<T> implements Generator<T>{
 * 如果不声明泛型，如：class FruitGenerator implements Generator<T>，编译器会报错："Unknown class"
 */
public class FruitGenerator<T> implements Generator<T> {
    @Override
    public T method() {
        return null;
    }
}

/**
 * 传入泛型实参时：
 * 定义一个类实现这个接口,虽然我们只创建了一个泛型接口 Generator<T>
 * 但是我们可以为 T 传入无数个参数类型,形成了无数个参数的 Generator 接口
 * 在实现类实现泛型接口时,如果将泛型类型传入实参类型,则所有使用泛型的地方都要替换成传入的实参类型
 *  即：Generator<String>, public T method()中的 T 也要替换成 String类型
 */
class FruitGenerator2<T> implements Generator<String> {
    @Override
    public String method() {
        return "good";
    }
}