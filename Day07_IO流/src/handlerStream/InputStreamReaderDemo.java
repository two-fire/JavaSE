package handlerStream;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * InputStreamReader 是字节流通向字符流的桥梁：它使用指定的 charset 读取字节并将其解码为字符。
 * 它使用的字符集可以由名称指定或显式给定，或者可以接受平台默认的字符集。
 */
public class InputStreamReaderDemo {
    public static void main(String[] args) {

//        // 网络编程
//        ServerSocket serverSocket = null;
//        try {
//            serverSocket = new ServerSocket(10086);
//            Socket socket = serverSocket.accept();
//            socket.getOutputStream(); // 没有getWriter()
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        File file = new File("avc.txt");
        FileInputStream fileInputStream = null;
        InputStreamReader inputStreamReader = null;

        try {
            fileInputStream = new FileInputStream(file);
            inputStreamReader = new InputStreamReader(fileInputStream,"gbk");
            // 为什么没有用循环方式？因为数据较少，无法占用1024个缓冲区，读取一次即可
            char[] chars = new char[1024];
            int len = inputStreamReader.read(chars);
            System.out.println(new String(chars,0,len));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStreamReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
