package client;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

/**
 * 客户端向服务端传送消息
 * 先后启动无顺序
 */
public class UDPClient {
    public static void main(String[] args) throws Exception {
        // 创建UDP通信的socket 自己对应的端口
        DatagramSocket datagramSocket = new DatagramSocket(10000);
        // 从控制台读取数据
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        // 远程的地址和端口
        DatagramPacket datagramPacket = new DatagramPacket(str.getBytes(),str.length(),
                InetAddress.getByName("localhost"),10001);
        // 发送数据
        datagramSocket.send(datagramPacket);
        datagramSocket.close();
    }
}
