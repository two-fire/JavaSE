package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class PicServer {
    public static void main(String[] args) throws IOException {
        // 创建服务端对象，开放端口
        ServerSocket serverSocket = new ServerSocket(10086);
        // 创建服务端的套接字
        Socket server = serverSocket.accept();
        // 获取输入流对象
        InputStream inputStream = server.getInputStream();
        // 创建文件输出流对象
        FileOutputStream fileOutputStream = new FileOutputStream("gouzi.jpg");
        int temp = 0;
        while ((temp = inputStream.read()) != -1) {
            fileOutputStream.write(temp);
        }
        // 添加流输入完成的标志
        server.shutdownInput();

        //上传图片结束后，给予客户端响应
        OutputStream outputStream = server.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
//        outputStream.write("上传成功".getBytes());
        dataOutputStream.writeUTF("上传成功");
        server.shutdownOutput();
        // 关闭
        dataOutputStream.close();
        outputStream.close();
        fileOutputStream.close();
        inputStream.close();
        server.close();
        serverSocket.close();
    }
}
