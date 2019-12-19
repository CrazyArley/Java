package cn.wengzi.mail;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.*;
import java.util.Date;
import java.util.Properties;

/**
 * @author leizige
 * @date 2019-12-19 night 23:00
 * desc:发送邮件
 */
public class testMail {
    public static void main(String[] args) throws IOException, MessagingException {

        //1.创建一封邮件
        Properties properties = new Properties();   // 用于连接邮件服务器的参数配置（发送邮件时才需要用到）
        Session session = Session.getInstance(properties);   // 根据参数配置，创建会话对象（为了发送邮件准备的）
        session.setDebug(true);        //开启邮件发送日志
        MimeMessage message = new MimeMessage(session); //创建邮件对象

        /**
         * 2. From: 发件人
         *      其中 InternetAddress 的三个参数分别为: 邮箱, 显示的昵称(只用于显示, 没有特别的要求), 昵称的字符集编码
         *      真正要发送时, 邮箱必须是真实有效的邮箱。
         */
        message.setFrom(new InternetAddress("qx_leizige@163.com", "USER_AA", "UTF-8"));

        //3.TO 收件人  其中new InternetAddress[] 是一个数组,可以添加多个收件人
        message.setRecipients(Message.RecipientType.TO, new InternetAddress[]{new InternetAddress("Hush.TianLLei@outlook.com", "USER_BB", "UTF-8")});
        //  Cc: 抄送（可选）
        //message.setRecipient(MimeMessage.RecipientType.CC,new InternetAddress("Hush.TianLLei@outlook.com", "USER_BB", "UTF-8"));
        //  Bcc: 密送（可选）
        //message.setRecipient(MimeMessage.RecipientType.BCC, new InternetAddress("Hush.TianLLei@outlook.com", "USER_FF", "UTF-8"));

        //4.Subject:邮件主题
        message.setSubject("这是邮件主题", "UTF-8");

        //5.Content:邮件正文(可以使用html标签)
        message.setContent("这是邮件正文", "text/html;charset=UTF-8");

        //6.Date:设置显示的发件时间
        message.setSentDate(new Date());

        //7.保存邮件设置
        message.saveChanges();

        //8.将邮件保存本地
        OutputStream outputStream = new FileOutputStream("D:\\myEmail.eml");
        message.writeTo(outputStream);
        outputStream.flush();
        outputStream.close();

    }
}
