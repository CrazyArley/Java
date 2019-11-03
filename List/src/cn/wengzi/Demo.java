package cn.wengzi;

import java.lang.reflect.Field;
import java.util.*;

/**
 * @author wengzi
 * @date 2019/11/15 13:52
 */
public class Demo {
    public static void main(String[] args) {
        reverse();
        System.out.println();
        remove();
        System.out.println();
        reverse2();
    }

    private static int num = 10;

    /**
     * @Description ArrayList倒序排序
     */
    public static void reverse() {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= num; i++) {
            list.add(i);
        }

        Collections.reverse(list);

        list.forEach(integer -> System.out.print(integer + ","));
    }

    /**
     * @Description ArrayList倒序排序
     * 先正向排序,再通过 hasPrevious 方法倒序输出
     */
    public static void reverse2() {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= num; i++) {
            list.add(i);
        }

        ListIterator<Integer> integerListIterator = list.listIterator();
        while (integerListIterator.hasNext()) {
            System.out.print(integerListIterator.next() + ",");
        }
        System.out.println();
        while (integerListIterator.hasPrevious()) {
            System.out.print(integerListIterator.previous() + ",");
        }
    }

    /**
     * @Description Java集合类ArrayList循环中删除特定元素
     */
    public static void remove() {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= num; i++) {
            list.add(i);
        }

        ListIterator<Integer> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            Integer i = listIterator.next();
            if (i.equals(3) || i.equals(7)) {
                listIterator.remove();
            }
        }

        list.forEach(integer -> System.out.print(integer + ","));
    }

    /**
     * 反射获取ArrayList容量
     *
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    public static void getCapacity() throws NoSuchFieldException, IllegalAccessException {
        ArrayList arrayList = new ArrayList();
        Class<? extends ArrayList> Clazz = arrayList.getClass();
        Field elementData = Clazz.getDeclaredField("elementData");
        elementData.setAccessible(true);
        Object[] objects = (Object[]) elementData.get(arrayList);
        System.out.println(objects.length);
    }
}
