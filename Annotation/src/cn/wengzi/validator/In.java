package cn.wengzi.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target({
        ElementType.FIELD,
        ElementType.METHOD,
        ElementType.ANNOTATION_TYPE,
        ElementType.CONSTRUCTOR,
        ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {InValidator.class})
public @interface In {

    String message() default "The value is not within a given range.";

    int[] values() default {};

    /* 下面这两个属性必须添加 */
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
