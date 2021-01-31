package server;

import java.io.*;
import java.net.Socket;

public class ServerThread implements Runnable{
    private Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            //------------接收客户端数据---------------
            // 通过server获取输入流对象
            InputStream inputStream = null;
            inputStream = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader br = new BufferedReader(inputStreamReader);
            //------------向客户端输出数据---------------
            OutputStream outputStream = null;
            outputStream = socket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream, true);
            InputStreamReader isr2 = new InputStreamReader(System.in);
            BufferedReader br2 = new BufferedReader(isr2);
            while (true) {
                String str = null; //读出缓存区数据
                str = br.readLine();
                System.out.println("客户端说：" + str);

                System.out.println("我说：");
                String str2 = null;
                str2 = br2.readLine();
                printWriter.println(str2);
            }
        } catch (Exception e){

        }
    }
}

