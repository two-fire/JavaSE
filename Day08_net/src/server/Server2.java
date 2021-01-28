package server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2 {
    public static void main(String[] args) throws IOException {
        // 创建servertsocket对象
        ServerSocket serverSocket = new ServerSocket(10000);
        // 获取服务器的套接字对象
        Socket server = serverSocket.accept();
        //-------------接受客户端的输入----------------
        // 获取输入流对象
        InputStream inputStream = server.getInputStream();
        byte[] buf = new byte[1024];
        int length = inputStream.read(buf);
        System.out.println("客户端传输的数据是：" +new String(buf,0,length));
        //-------------向进客户端进行输出----------------
        OutputStream outputStream = server.getOutputStream();
        // 数据输出
        outputStream.write("hello from server".getBytes());

        // 关闭流对象
        outputStream.close();
        inputStream.close();
        server.close();
        serverSocket.close();
    }
}
