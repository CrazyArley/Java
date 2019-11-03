package cn.wengzi.reflect.test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 动态加载class.properties中的类名和方法
 */
public class test3 {
    private static Properties properties = new Properties();
    private static InputStream inputStream = null;

    public static void main(String[] args) throws IOException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {

        Class<?> perClass = null;

        inputStream = test3.class.getResourceAsStream("/class.properties");
        properties.load(inputStream);

        String ClassName = properties.getProperty("ClassName");
        String MethodName = properties.getProperty("MethodName");

        //System.out.println(ClassName);
        //System.out.println(MethodName);

        try {
            perClass = Class.forName(ClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Method method = perClass.getDeclaredMethod(MethodName);
        method.setAccessible(true);
        method.invoke(perClass.newInstance());
    }
}
