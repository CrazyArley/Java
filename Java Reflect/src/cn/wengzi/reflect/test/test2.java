package cn.wengzi.reflect.test;

import cn.wengzi.reflect.entity.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class test2 {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        Class<?> perClass = null;

        //1：通过反射获取对象实例并操作对象
        try {
            perClass = Class.forName("cn.wengzi.reflect.entity.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Object newInstance = perClass.newInstance();
        Person person = (Person) newInstance;
        person.setId(1);
        person.setName("张三");
        person.setAge(23);
        person.setAddress("太原");
        //System.out.println(person);

        //2：操作属性
        Field nameField = perClass.getDeclaredField("name");
        //访问的是private的name,但是private是私有的;
        //在使用反射时,如果因为访问修饰符权限问题引发的异常 setAccessible(true)解决;
        nameField.setAccessible(true);
        nameField.set(person,"李四");
        //System.out.println(person.getName());


        //3:操作方法
        //  无参方法
        Method method = perClass.getDeclaredMethod("privateMethod", null);
        method.setAccessible(true);
        //method.invoke(person,null);   //方法的调用invoke();

        //带参方法
        Method method1 = perClass.getDeclaredMethod("privateMethodParam", String.class);
        method1.setAccessible(true);
        //method1.invoke(person,"我是传递的参数");

        //4:操作构造方法
            //带参构造方法
        Constructor<?> constructor = perClass.getConstructor(Integer.class, String.class, Integer.class, String.class);
        System.out.println(constructor);
            //无参构造方法
        Constructor<?> constructorNullParam = perClass.getConstructor();
        System.out.println(constructorNullParam);
            //通过构造方法操作对象
        Person constructorPerson = (Person)constructor.newInstance(1,"王五",25,"山西");
        System.out.println(constructorPerson);
    }
}
