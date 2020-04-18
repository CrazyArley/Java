package cn.wengzi.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Arley
 * @date 2020/04/18
 * desc:验证属性在In范围内
 */
public class InValidator implements ConstraintValidator<In, Integer> {

    private int[] checkedValues;

    /**
     * 初始参数,获取注解values的值
     */
    @Override
    public void initialize(In constraintAnnotation) {
        checkedValues = constraintAnnotation.values();
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext constraintValidatorContext) {
        if (null == value) {
            return false;
        }
        for (int checkedValue : checkedValues) {
            if (value.equals(checkedValue)) {
                return true;
            }
        }
        return false;
    }
}
