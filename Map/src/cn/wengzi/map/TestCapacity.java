package cn.wengzi.map;

import com.sun.xml.internal.ws.util.StringUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @author wengzi
 * @date 19/10/8 20:58
 */
public class TestCapacity {
    public static void main(String[] args) {
        int aHundredMillion = 10000000;

        Map<Integer, Integer> map = new HashMap<>(0);

        long start = System.currentTimeMillis();

        for (int i = 0; i < aHundredMillion; i++) {
            map.put(i, i);
        }

        long end = System.currentTimeMillis();

        System.err.println("未初始化容量时,耗时:" + (end - start));


        Map<Integer, Integer> map1 = new HashMap<>(aHundredMillion / 2);

        long start1 = System.currentTimeMillis();

        for (int i = 0; i < aHundredMillion; i++) {
            map1.put(i, i);
        }

        long end1 = System.currentTimeMillis();

        System.err.println("初始化容量为5000000,耗时:" + (end1 - start1));

        Map<Integer, Integer> map3 = new HashMap<>(aHundredMillion);

        long start3 = System.currentTimeMillis();

        for (int i = 0; i < aHundredMillion; i++) {
            map3.put(i, i);
        }

        long end3 = System.currentTimeMillis();

        System.err.println("初始化容量为10000000,耗时:" + (end3 - start3));
    }

    /**
     * 未初始化容量时,耗时:6055
     * 初始化容量为50000000,耗时:4250
     * 初始化容量为10000000,耗时:3143
     */
    //HashMap中将要存放的KV个数的时候，设置一个合理的初始化容量可以有效的提高性能。
}

class Test2 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(16);
        map.put(1, 1);


        Class<? extends Map> Clazz = map.getClass();
        Method capacity = Clazz.getDeclaredMethod("capacity");
        capacity.setAccessible(true);
        System.out.println(capacity.invoke(map));

        Map<Object, Object> map2 = new HashMap<Object, Object>(16);
        map2.put(null, "aa");
        Iterator<Map.Entry<Object, Object>> iterator = map2.entrySet().iterator();
        iterator.forEachRemaining(k -> System.out.println(k.getKey() + "" + k.getValue()));

    }
}
