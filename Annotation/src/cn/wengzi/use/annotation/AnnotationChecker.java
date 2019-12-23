package cn.wengzi.use.annotation;

import cn.wengzi.use.annotation.CustomAnnotation;
import cn.wengzi.use.util.CommonPostCode;
import cn.wengzi.use.util.PostingException;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 解析自定义注解并完成校验
 */
@SuppressWarnings("unchecked")
public class AnnotationChecker {

    public static final Map<String, Field[]> filedMap = new ConcurrentHashMap<>();

    public AnnotationChecker() {
        super();
    }

    public static void checkedParam(Object object) throws Exception {
        Class<?> clazz = object.getClass();
        Field[] fields = null;
        if (filedMap.containsKey(clazz.getName())) {
            fields = filedMap.get(clazz.getName());
        } else {
            fields = clazz.getDeclaredFields();
            filedMap.put(clazz.getName(), fields);
        }

        for (Field field : fields) {
            synchronized (field) {
                field.setAccessible(true);
                check(field,object);
                field.setAccessible(false);
            }
        }
    }

    private static void check(Field field, Object object) throws Exception {
        String description;
        Object value = null;
        CustomAnnotation annotation = field.getAnnotation(CustomAnnotation.class);

        value = field.get(object);


        if (annotation == null) return;

        description = annotation.description().equals("") ? field.getName() : annotation.description();

        if (!annotation.isNull()) {
            if (value == null || value.toString().trim().equals("")) {
                throw new PostingException(CommonPostCode.PARAM_LENGTH.getErrorCode(), description + " " + CommonPostCode.PARAM_NULL.getErrorMessage());
            }
        }
        if (value.toString().length() > annotation.maxLength()) {
            throw new PostingException(CommonPostCode.PARAM_LENGTH.getErrorCode(), description + " " + CommonPostCode.PARAM_LENGTH.getErrorCode());
        }
    }
}
