package Encode;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * 使用 sha256 进行加密 字节串 --> 十六进制串
 * 速度较慢,相对于md5而言,安全性较高
 * <p>
 * 加密结果不可逆
 */
public class sha256Encode {



    /**
     * 传入 byte[]类型数组,返回加密后的 结果String
     *
     * @param data byte[]
     * @return String
     */
    public static String Sha256Encode(byte[] data) {
        return DigestUtils.sha256Hex(data);
    }

    public static void main(String[] args) {
        String str = "Hello";
        str = Sha256Encode(str.getBytes());
        System.out.println(str);
    }
}
