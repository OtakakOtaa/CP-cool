package org.example.Client;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class ClientBootstrap {
    private static final int PORT = 1050;

    public static void main(String[] args) {
        try {

            initConnection();
            sendParamsToServer();
            var result = waitServerResponse();
            System.out.println(result);

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            dispose();
        }

    }

    private static void initConnection() throws SocketException, UnknownHostException {
        socket = new DatagramSocket();
        address = InetAddress.getByName("localhost");
        System.out.println("Client : initConnection successful");
    }

}
