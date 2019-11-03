package cn.wengzi.map;

import java.util.*;

/**
 * @author wengzi
 * @date 19/10/8 20:58
 * @Description Map遍历
 */
public class IteratorMap {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "a");
        map.put(2, "b");
        map.put(3, "c");

        //第一种：普遍使用，二次取值
        //keySet()方法返回值是Map中key值的集合
        System.out.println("通过Map.keySet遍历key和value");
        for (Integer key : map.keySet()) {
            System.out.println("key:" + key + "--" + "value:" + map.get(key));
        }

        //第二种
        //entrySet()的返回值也是返回一个Set集合，此集合的类型为Map.Entry
        System.out.println("通过Map.entrySet使用iterator遍历key和value");
        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> entry = iterator.next();
            System.out.println("key:" + entry.getKey() + "--" + "value:" + entry.getValue());
        }

        //第三种：推荐，尤其是容量大时
        System.out.println("通过Map.entrySet遍历key和value");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println("key:" + entry.getKey() + "--" + "value:" + entry.getValue());
        }

        //第四种
        System.out.println("通过Map.values遍历所有的value,但是不能遍历key");
        for (String value : map.values()) {
            System.out.println("value:" + value);
        }
    }
}
