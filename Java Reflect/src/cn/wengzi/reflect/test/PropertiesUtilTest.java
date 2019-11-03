package cn.wengzi.reflect.test;

import cn.wengzi.reflect.entity.Person;
import cn.wengzi.reflect.entity.Student;
import cn.wengzi.reflect.util.PropertiesUtil;

/**
 * 测试PropertiesUtil类
 */
public class PropertiesUtilTest {
    public static void main(String[] args) {
        Person person = new Person();
        try {
            PropertiesUtil.setProperties(person, "id", 1);
            PropertiesUtil.setProperties(person, "name", "张三");
            PropertiesUtil.setProperties(person, "age", 23);
            PropertiesUtil.setProperties(person, "address", "山西");
            System.out.println(person);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        Student student = new Student();
        try {
            PropertiesUtil.setProperties(student, "name", "张三");
            PropertiesUtil.setProperties(student, "score", 100);
            System.out.println(student);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
