package com;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Send {
    public static void main(String[] args) throws IOException {

        byte[] bytes1 = "方达电子1".getBytes();
        File file = new File("c:/UDP/socket.txt");
//        FileOutputStream fileOutputStream = new FileOutputStream(file);
//        fileOutputStream.write(bytes1);
//        fileOutputStream.close();
        FileInputStream fileInputStream = new FileInputStream(file);
//        System.out.println(fileInputStream.available());
        byte[] bytes=new byte[Integer.parseInt(String.valueOf(file.length()))];
        fileInputStream.read(bytes);
//        int read = fileInputStream.read();
        System.out.println(new String(bytes));

        String message = "这是一个消息";
//        byte[] bytes = message.getBytes();
        int begin = 0;
        int length = bytes.length;
        InetAddress ip = InetAddress.getByName("localhost");
        int port = 9090;
        DatagramPacket packet = new DatagramPacket(bytes, begin, length, ip, port);
        DatagramSocket socket = new DatagramSocket();
        socket.send(packet);

        fileInputStream.close();
        socket.close();
    }
}
