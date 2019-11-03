package cn.wengzi;

/**
 * @author wengzi
 * @date 2019/10/19 下午15:06
 */
public class TestEnum {
    public void judge(SeasonEnum seasonEnum) {
        switch (seasonEnum) {
            case SPRING:
                System.out.println("春暖花开");
                break;
            case SUMMER:
                System.out.println("夏日炎炎");
                break;
            case FALL:
                System.out.println("秋高气爽");
                break;
            case WINTER:
                System.out.println("冬日飘雪");
                break;
            default:
                System.out.println("什么都没有...");
                break;
        }
    }

    public static void main(String[] args) {
        //所有枚举类只有一个values方法,用来返回该枚举类的所有实例
        for (SeasonEnum value : SeasonEnum.values()) {
            System.out.println(value);
        }
        //通过EnumClass.variable形式访问
        new TestEnum().judge(SeasonEnum.FALL);
    }
}
