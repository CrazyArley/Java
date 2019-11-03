package cn.wengzi.concurrent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author wengzi
 * @date 2019/10/17 下午17:51
 * @Description 构建线程安全的ArrayList
 */
public class ConcurrentList {
    public static void main(String[] args) {
        /**
         * Vector:Vector(类似与ArrayList)但是其是同步的.
         * 所有方法带有同步锁,性能不是最优.
         */
        Vector<String> vector = new Vector<>();

        /**
         * synchronizedList:将List接口的实现类转换为线程安全的List,比Vector有更好的扩展性和兼容性.
         * 所有方法带有同步锁,和Vector一样,性能不是最优.
         */
        List<Object> synchronizedList = Collections.synchronizedList(new ArrayList<>());

        /**
         * CopyOnWriteArrayList:即复制再写入,就是在添加元素的时候,先把原来的List复制一份,再添加新的元素.
         * add():添加元素时,先加锁,在进行复制替换操作,最后再释放锁
         * get():获取元素时并没有加锁.再高并发场景下,读取元素时就不用加锁,写数据时才加锁,大大提升了读取性能.
         */
        CopyOnWriteArrayList<String> cow = new CopyOnWriteArrayList<>();
        cow.add("one");


        /**
         * CopyOnWriteArraySet:
         * add():使用CopyOnWriteArrayList的addIfAbsent()来去重,添加元素时判断对象是否存在,不存在才添加进集合.
         */
        CopyOnWriteArraySet<String> coe = new CopyOnWriteArraySet<>();
    }
}
