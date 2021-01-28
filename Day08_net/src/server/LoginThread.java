package server;

import client.User;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 多线程解决
 */
public class LoginThread implements Runnable {

    // 表示每个对象都是一个连接
    private Socket socket;

    public LoginThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        ObjectInputStream objectInputStream = null;
        DataOutputStream dataOutputStream = null;
        try {
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            User user = (User) objectInputStream.readObject();
            String str = "";
            if ("msb".equals(user.getUsername()) && "123".equals(user.getPassward())) {
                System.out.println("欢迎您, "+user.getUsername());
                str = "登陆成功";
            } else {
                str = "登陆失败";
            }
            socket.shutdownInput();
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
            dataOutputStream.writeUTF(str);
            socket.shutdownOutput();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                dataOutputStream.close();
                objectInputStream.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
