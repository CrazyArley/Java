package cn.wengzi.reflect.test;

import cn.wengzi.reflect.entity.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class test1 {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Class<?> perClass = null;
        try {
            perClass = Class.forName("cn.wengzi.reflect.entity.Person");
            //获取到的类名
            //System.out.println(perClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        /**
         * 获取所有公共方法
         *  1.本类以及父类、接口中的所有方法
         *  2.符合访问修饰符规律
         */Method[] methods = perClass.getMethods();
        for (Method method : methods) {
            //System.out.println(method);
        }

        /**
         * 获取当前类中所有方法
         *  1.只能是当前类
         *  2.忽略访问修饰符规则
         */
        Method[] declaredMethods = perClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            //System.out.println(declaredMethod);
        }

        /**
         * 获取当前类中所有接口
         */
        Class<?>[] interfaces = perClass.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            //System.out.println(anInterface);
        }

        /**
         * 获取所有父类
         */
        Class<?> superclass = perClass.getSuperclass();
        //System.out.println(superclass);

        /**
         * 获取所有构造方法
         */
        Constructor<?>[] constructors = perClass.getConstructors();
        for (Constructor<?> constructor : constructors) {
            //System.out.println(constructor);
        }

        /**
         * 获取当前类所有公共属性
         */
        Field[] fields = perClass.getFields();
        for (Field field : fields) {
            //System.out.println(field);
        }

        /**
         * 获取当前类所有属性
         */
        Field[] declaredFields = perClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            //System.out.println(declaredField);
        }

        /**
         * 获取当前反射所代表类(接口)的对象(实例)
         */
        Object newInstance = perClass.newInstance();
        Person person = (Person) newInstance;
        person.staticMethod();
    }
}
