package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 多线程解决
 */
public class Server3 {
    public static void main(String[] args) throws IOException {
        // 服务端需要使用serversocket来开放本地的端口
        ServerSocket serverSocket = new ServerSocket(10001);
        Socket socket = serverSocket.accept();
        ServerThread serverThread = new ServerThread(socket);
        new Thread(serverThread).start();
    }
}
