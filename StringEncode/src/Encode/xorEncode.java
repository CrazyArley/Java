package Encode;

/**
 * 使用 异或 进行加密解密
 * <p>
 * 加密结果可逆
 * <p>
 * 第一次进行异或 (得到加密后的值 123abc): apple --> 123abc
 * 第二次进行异或(对加密后的值进行异或,得到原始字符串): 123abc --> apple
 */
public class xorEncode {

    /**
     * 传入 要加密的 String 返回加密后的 String
     *
     * @param data String 字符串
     */
    public static String XorEncode(String data) {
        //将传入的 字符串 转换为字符数组
        char[] chars = data.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            //将字符串的每一个值 与3000 进行异或加密
            chars[i] = (char) (chars[i] ^ 3000);
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        String str = "Hello";

        str = XorEncode(str);   //第一次异或
        System.out.println(str);

        str = XorEncode(str);
        System.out.println(str);//第二次异或
    }
}
