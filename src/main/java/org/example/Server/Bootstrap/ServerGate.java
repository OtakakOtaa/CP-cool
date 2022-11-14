package org.example.Server.Bootstrap;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerGate {
    private final ServerSocket server;
    private boolean isOpenGate;
    private static final int PORT = 4006;

    public ServerGate() throws Exception {
        try {
            server = new ServerSocket(PORT);
        } catch (IOException e) {
            throw ExceptionHolder.ServerGateEx.serverInitEx;
        }
    }

    public void listenGate() throws Exception {
        while (isOpenGate) {
            var clientSocket = server.accept();
            CreateSession(clientSocket).start();
        }
    }

    public void drop() throws Exception {
        try {
            isOpenGate = false;
            server.close();
        } catch (IOException e) {
            throw ExceptionHolder.ServerGateEx.serverDropEx;
        }
    }

    private Thread CreateSession(Socket clientSocket) {
        return new Thread(() -> {
            try {
                initSession(clientSocket);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

    private void initSession(Socket clientSocket) throws Exception {
        Session session = null;
        try {
            session = new Session(clientSocket);
        } catch (IOException e) {
            throw ExceptionHolder.ServerGateEx.sessionOpenEx;
        } finally {
            if (session != null) session.dispose();
        }
    }

    private class Session {
        public final Socket clientSocket;
        public final BufferedReader in;
        public final BufferedWriter out;
        public final ObjectInputStream inObject;

        public Session(Socket clientSocket) throws Exception {
            try {
                this.clientSocket = clientSocket;

                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                inObject = new ObjectInputStream(clientSocket.getInputStream());
            } catch (IOException e) {
                throw ExceptionHolder.ServerGateEx.sessionOpenEx;
            }

        }

        public void dispose() throws Exception {
            try {
                in.close();
                inObject.close();
                out.close();
                clientSocket.close();
            } catch (IOException e) {
                throw ExceptionHolder.ServerGateEx.sessionCloseEx;
            }
        }
    }

    public static class ExceptionHolder {

        public static class ServerGateEx {
            private final static String context = ServerGate.class.getName() + "/";

            public final static Exception sessionOpenEx = new Exception(context + "Session open failed!");
            public final static Exception serverInitEx = new Exception(context + "Server init failed!");
            public final static Exception serverDropEx = new Exception(context + "Server drop failed!");
            public final static Exception sessionCloseEx = new Exception(context + "Session close failed!");
        }
    }

}
