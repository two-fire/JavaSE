package readerOrWriter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class PrintStreamTest {
    public static void main(String[] args) {
        PrintStream printStream = null;
        try {
            printStream = new PrintStream(System.out);
//            printStream = new PrintStream(new FileOutputStream("123.txt"));
            printStream.write("hello world".getBytes());
            printStream.println(true);
            System.out.println();
            // 格式化输出
            System.out.printf("%s--%d---%.2f","abc",123,11.1);
            // 错误输出 标红打印
            System.err.println("mashibing");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            printStream.close();
        }
    }
}
