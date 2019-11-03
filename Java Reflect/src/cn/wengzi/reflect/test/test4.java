package cn.wengzi.reflect.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 泛型可以越过类型检查
 */
public class test4 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<Integer> list = new ArrayList<>();
        list.add(123);
        list.add(456);

        Class<? extends List> listClass = list.getClass();
        Method method = listClass.getDeclaredMethod("add", Object.class);
        method.invoke(list, "张三");

//        list.forEach((e) -> System.out.print(e));
        System.out.println(list);
    }
}
