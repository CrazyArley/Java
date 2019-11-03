import Encode.md5Encode;

import java.util.Scanner;

/**
 * 使用md5加密, 模拟用户注册和登陆 对用户密码进行加密
 */
public class testEncode {

    String username;
    String password;
    Scanner input = new Scanner(System.in);

    md5Encode md5Encode = new md5Encode();

    /**
     * 模拟用户注册
     */
    public void register() {
        System.out.println("请输入用户名:");
        username = input.next();
        System.out.println("请输入密码:");
        password = input.next();
        //对注册密码进行加密
        password = md5Encode.Md5Encode(password.getBytes());
        System.out.println(password);
    }

    /**
     * 模拟用户登录
     *
     * @return
     */
    public boolean login() {
        boolean flag = false;
        System.out.println("请输入用户名:");
        String LoginUserName = input.next();
        System.out.println("请输入密码:");
        String LoginPassword = input.next();
        //对登陆密码进行加密
        LoginPassword = md5Encode.Md5Encode(LoginPassword.getBytes());
        System.out.println(LoginPassword);
        if (username.equals(LoginUserName) && password.equals(LoginPassword)) {
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    public static void main(String[] args) {
        testEncode encode = new testEncode();
        encode.register();
        boolean login = encode.login();
        if (login)
            System.out.println("登陆成功!");
        else
            System.out.println("登陆失败!");
    }
}
