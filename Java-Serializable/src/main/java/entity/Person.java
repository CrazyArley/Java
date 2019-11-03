package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * created by wengzi 19/8/7
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Person implements Serializable {
    private static final long serialVersionUID = -4526248578335738419L;
    /**
     * serialVersionUID 用来表明类的不同版本间的兼容性
     * Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的。
     * 在进行反序列化时，JVM会把传来 的字节流中的serialVersionUID与本地相应实体（类）
     * 的serialVersionUID进行比较，如果相同就认为是一致的，可以进行反序 列化，否则就会出现序列化版本不一致的异常。
     */

    private String name;
    private Integer age;
    //private transient String address;
}





/*
    序列化及反序列化:
        1、在Java中，只要一个类实现了java.io.Serializable接口，那么它就可以被序列化。
        2、通过ObjectOutputStream和ObjectInputStream对对象进行序列化及反序列化
        3、虚拟机是否允许反序列化，不仅取决于类路径和功能代码是否一致，一个非常重要的一点是两个类的序列化 ID 是否一致（就是 private static final long serialVersionUID）
        4、序列化并不保存静态变量。
        5、要想将父类对象也序列化，就需要让父类也实现Serializable 接口。
        6、Transient 关键字的作用是控制变量的序列化，在变量声明前加上该关键字，可以阻止该变量被序列化到文件中，在被反序列化后，transient 变量的值被设为初始值，如 int 型的是 0，对象型的是 null。
        7、服务器端给客户端发送序列化对象数据，对象中有一些数据是敏感的，比如密码字符串等，希望对该密码字段在序列化时，进行加密，而客户端如果拥有解密的密钥，只有在客户端进行反序列化时，才可以对密码进行读取，这样可以一定程度保证序列化对象的数据安全。
**/