package Encode;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * 使用Md5进行加密 ,字节串 --> 十六进制串
 * 速度较快,相对于sha256而言,安全性较低
 * <p>
 * 加密结果不可逆
 */
public class md5Encode {

    /**
     * 传入 byte[]类型数组,返回加密后的 结果String
     *
     * @param data byte[]
     * @return String
     */
    public static String Md5Encode(byte[] data) {
        return DigestUtils.md5Hex(data);
    }

    public static void main(String[] args) {
        String str = "Hello";
        str = Md5Encode(str.getBytes());
        System.out.println(str);
    }

}
