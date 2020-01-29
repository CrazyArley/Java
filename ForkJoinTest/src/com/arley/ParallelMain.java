package com.arley;

import org.omg.PortableInterceptor.SUCCESSFUL;

import java.time.Instant;

/**
 * @author Arley
 * 2020/1/29
 */
public class ParallelMain {


    public static void main(String[] args) {
        long start = Instant.now().toEpochMilli();

        long i;
        long sum = 0L;
        for (i = 0L; i < 100000000L; i++) {
            sum = sum + i;
        }
        System.out.println(sum);
        long end = Instant.now().toEpochMilli();

        System.out.println("for 循环单线程执行 耗费时间 :" + (end - start) + "ms");
    }
}
