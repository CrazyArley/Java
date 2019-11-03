package cn.wengzi.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author wengzi
 * @date 2019/10/20 下午16:08
 * @description 使用反射提取 Annotation 的信息
 */
public class ReflectAnnotation {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        showAnnotation();
    }

    /**
     * 通过反射获取 Test 类中的 info 方法所有注释
     *
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     */
    public static void showAnnotation() throws ClassNotFoundException, NoSuchMethodException {
        Class<?> Clazz = Class.forName("cn.wengzi.Test");
        Method info = Clazz.getMethod("info");
        Annotation[] annotations = info.getAnnotations();

        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
    }
}
