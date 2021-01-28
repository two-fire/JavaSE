package server;

import client.User;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class LoginServer {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket serverSocket = new ServerSocket(10000);
        Socket server = serverSocket.accept();
        // 获取输入流对象
        InputStream inputStream = server.getInputStream();
        // 需要使用ObjectInputStream对象
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        // 读对象
        User user = (User) objectInputStream.readObject();
        String str = "";
        if ("msb".equals(user.getUsername()) && "123".equals(user.getPassward())) {
            System.out.println("欢迎您, "+user.getUsername());
            str = "登陆成功";
        } else {
            str = "登陆失败";
        }
        // 截断输入流
        server.shutdownInput();
        // 给客户端响应
        DataOutputStream outputStream = new DataOutputStream(server.getOutputStream());
        outputStream.writeUTF(str);
        server.shutdownOutput();
        // 关闭流
        outputStream.close();
        inputStream.close();
        server.close();
        serverSocket.close();
    }
}
