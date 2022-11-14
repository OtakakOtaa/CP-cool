package org.example.Client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class ClientLoop {

    private static DatagramSocket socket;
    private static InetAddress address;

    private static void sendParamsToServer() throws IOException {
        Scanner in = new Scanner(System.in);

        System.out.println("Client : sendParamsToServer successful");
    }

    private static String waitServerResponse() throws IOException {
        var buffer = new byte[256];
        DatagramPacket pack = new DatagramPacket(buffer, buffer.length);
        socket.receive(pack);

        var result = new String(pack.getData(), 0, pack.getLength());

        System.out.println("Client : waitServerResponse successful");
        return result;
    }

    private static void send(String msg) throws IOException {
        byte[] buffer = msg.getBytes();
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, PORT);
        socket.send(packet);
    }

    private static void dispose() {
        socket.close();
    }
}
