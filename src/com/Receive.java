package com;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Receive {
    public static void main(String[] args) throws IOException {
        byte[] bytes =new byte[18];
        DatagramPacket packet = new DatagramPacket(bytes,0,18);
        DatagramSocket socket = new DatagramSocket(9090);
        socket.receive(packet);
        System.out.println(new String(bytes));

    }
}
