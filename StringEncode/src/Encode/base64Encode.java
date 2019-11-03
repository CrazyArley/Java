package Encode;

import java.util.Base64;

/**
 * 使用base64进行加密
 * <p>
 * 加密结果可逆
 */
public class base64Encode {
    /**
     * 传入 byte[]类型数组,返回加密后的 结果String
     *
     * @param data byte[]
     * @return String
     */
    public static String Base64Encode(byte[] data) {
        return Base64.getEncoder().encodeToString(data);
    }

    /**
     * 传入 加密后的字符串 进行解密,返回 byte[]数组
     *
     * @param data String
     * @return byte[]
     */
    public static byte[] Base64Decode(String data) {
        return Base64.getDecoder().decode(data);
    }

    public static void main(String[] args) {
        String str = "Hello";
        str = Base64Encode(str.getBytes()); //加密
        System.out.println(str);

        byte[] bytes = Base64Decode(str);   //解密
        str = new String(bytes);
        System.out.println(str);
    }
}
