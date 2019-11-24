package cn.wengzi;

/**
 * @author wengzi
 * @date 2019/10/19 下午15:03
 * @description 枚举, 使用enum定义枚举的类默认继承了java.lang.Enum类,而不是继承Object类
 */
public enum SeasonEnum {

    /**
     * 春夏秋冬,多个枚举之间使用 "," 分割
     */
    SPRING, SUMMER, FALL, WINTER;

    /**
     * 枚举类的构造器只能使用private修饰,如果省略,则默认使用private修饰.
     */
    private SeasonEnum() {

    }
}
