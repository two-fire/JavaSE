package client;

import java.io.*;
import java.net.Socket;

/**
 * 客户端
 */
public class Client3 {
    public static void main(String[] args) throws IOException {
        // 创建socket对象，指定数据接收方的ip地址和端口号
        Socket client = new Socket("localhost", 10001);
        //----------------从控制台输入服务器端输出----------
        // 从控制台输入数据
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        // 存入缓冲区
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        // 获取输出流对象，向服务端发送数据
        OutputStream outputStream = client.getOutputStream();
        PrintWriter printWriter = new PrintWriter(outputStream, true);
        //------------接收服务器端数据--------------------
        InputStream inputStream = client.getInputStream();
        InputStreamReader inputStreamReader2 = new InputStreamReader(inputStream);
        BufferedReader bufferedReader2 = new BufferedReader(inputStreamReader2);

        while (true) {
            System.out.println("我说：");
            String str = bufferedReader.readLine(); // 获取数据
            printWriter.println(str);

            String receive = bufferedReader2.readLine(); // 获取数据
            System.out.println("服务器说：" + receive);
        }
    }
}
