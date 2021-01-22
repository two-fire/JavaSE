package streamtype;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * ByteArrayInputStream包含一个内部缓冲区，其中包含可以从流中读取的字节。
 * 内部计数器跟踪read方法要提供的下一个字节。
 * 关闭ByteArrayInputStream没有任何效果。
 * 在关闭流之后，可以调用此类中的方法，而不生成IOException。
 */
public class ByteArrayInputStreamDemo {
    public static void main(String[] args) {

        String str = "www.baidu.com";
        byte[] buffer = str.getBytes();
        ByteArrayInputStream byteArrayInputStream = null;

        byteArrayInputStream = new ByteArrayInputStream(buffer);
        int read = 0;
        while ((read = byteArrayInputStream.read()) != -1) {
            byteArrayInputStream.skip(4);
            System.out.println((char)read);
        }
        try {
            byteArrayInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
