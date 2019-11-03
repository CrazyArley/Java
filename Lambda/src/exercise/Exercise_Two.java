package exercise;

import java.util.ArrayList;
import java.util.List;

public class Exercise_Two {
    public static void main(String[] args) {
        //集合遍历
        List<Integer> lists = new ArrayList<>();
        lists.add(10);
        lists.add(11);
        lists.add(12);
        lists.add(13);
        lists.add(14);
        lists.add(15);
        lists.add(16);

        //将集合中的每一个元素带入到方法accept中
        lists.forEach(System.out::println);

        //输出集合中所有偶数
        lists.forEach(num ->{
            if(num%2 == 0){
                System.err.println(num);
            }
        });
    }
}
