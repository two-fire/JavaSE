package client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 客户端向服务端发送数据
 *  先启动服务端，如果先启动客户端会报拒绝连接的错误
 *  如果启动两次服务端也会报错（地址被占用），因为端口只能绑定一次
 */
public class Client {
    public static void main(String[] args) throws IOException {
        // 创建socket对象，实际上是开启实现io的虚拟接口（此接口不是java中的接口，而是类似于网线的插槽）
        // 需要指定数据接收方的ip地址和端口号
        Socket client = new Socket("localhost",10086);
        // 获取输出流对象，向服务端发送数据
        OutputStream outputStream = client.getOutputStream();
        // 将输出流对象进行包装
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        // 传输数据
        dataOutputStream.writeUTF("hello,你好");
        // 关闭流操作
        dataOutputStream.close();
        outputStream.close();
        client.close();
    }
}
