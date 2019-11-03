package cn.wengzi.reflect.util;

import java.lang.reflect.Field;

public class PropertiesUtil {
    public static void setProperties(Object object, String propertiesName, Object value) throws NoSuchFieldException, IllegalAccessException {
        Class<?> objectClass = object.getClass();
        Field field = objectClass.getDeclaredField(propertiesName);
        field.setAccessible(true);
        field.set(object, value);
    }
}
