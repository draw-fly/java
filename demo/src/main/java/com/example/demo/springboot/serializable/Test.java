package com.example.demo.springboot.serializable;

import java.io.*;

public class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        serializableUser();
        deSerializableUser();
    }
    public static void serializableUser() throws IOException {
        User user = new User();
        user.setAge(18);
        user.setName("huangfeng");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C://test/serializable.txt"));
        oos.writeObject(user);
        oos.close();
        System.out.println("序列化对象成功！");
    }

    public static void deSerializableUser() throws IOException, ClassNotFoundException {
        File file = new File("C://test/serializable.txt");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        User user = (User)ois.readObject();
        ois.close();
        System.out.println("反序列化对象成功！" + user );
    }
}
