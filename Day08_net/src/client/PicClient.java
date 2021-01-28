package client;

import java.io.*;
import java.net.Socket;

public class PicClient {
    public static void main(String[] args) throws IOException {
        // 创建图片输入流对象
        FileInputStream fileInputStream = new FileInputStream("img.jpg");
        // 创建Socket
        Socket client = new Socket("localhost",10086);
        // 获取输出流对象
        OutputStream outputStream = client.getOutputStream();
        int temp = 0;
        while ((temp = fileInputStream.read()) != -1) {
            outputStream.write(temp);
        }
        client.shutdownOutput(); // 当数据比较大的时候，需要添加输入输出流完成的标志
        // --------------接受服务端的响应--------------
        InputStream inputStream = client.getInputStream();
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        System.out.println(dataInputStream.readUTF());
        client.shutdownInput();
        // 关闭流
        dataInputStream.close();
        inputStream.close();
        outputStream.close();
        fileInputStream.close();
        client.close();
    }

}
