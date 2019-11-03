package test;

import entity.Person;

import java.io.*;

/**
 * created by wengzi 19/8/7
 */
public class TestSerializable {

    public static void write() {
        Person person = new Person("你好胸", 23);

        //Write Obj to File
        ObjectOutputStream objectOutputStream = null;

        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream("D:\\person.json"));
            //通过 objectOutputStream 流将对象写入硬盘
            objectOutputStream.writeObject(person);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //关闭流
                objectOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void Reader() {
        ObjectInputStream objectInputStream = null;

        try {
            //通过 objectOutputStream 流将对象从硬盘中读取出来
            objectInputStream = new ObjectInputStream(new FileInputStream("D:\\person.json"));
            try {
                Person ReaderPerson = (Person) objectInputStream.readObject();
                System.out.println(ReaderPerson);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //关闭流
                objectInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //output
    //Person(name=你好胸, age=23)
    public static void main(String[] args) {
//        write();
        Reader();
    }
}
