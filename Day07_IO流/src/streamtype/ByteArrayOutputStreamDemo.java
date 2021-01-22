package streamtype;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * 该类实现了将数据写入字节数组的输出流。当数据写入缓冲区时，缓冲区会自动增长。
 */
public class ByteArrayOutputStreamDemo {
    public static void main(String[] args) {
        ByteArrayOutputStream byteArrayOutputStream = null;
        byteArrayOutputStream = new ByteArrayOutputStream();
        // write()将指定的字节写入此字节数组输出流 {
        byteArrayOutputStream.write(123);
        try {
            byteArrayOutputStream.write("www.baidu.com".getBytes()); // 无返回值
            System.out.println(byteArrayOutputStream.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                byteArrayOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
