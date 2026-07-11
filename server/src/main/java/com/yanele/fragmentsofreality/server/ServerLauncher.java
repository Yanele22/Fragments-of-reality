package com.yanele.fragmentsofreality.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerLauncher {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                new Thread(new ClientHandler(clientSocket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}