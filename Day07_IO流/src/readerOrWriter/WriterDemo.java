package readerOrWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;


/**
 * 什么时候需要加flush？
 *      保险起见，在输出流关闭之前，每次都进行flush再关闭。
 *      当某个输出流对象中带有缓冲区的时候就需要进行flush。
 *
 */
public class WriterDemo {
    public static void main(String[] args) {
        File file = new File("writer.txt");
        Writer writer = null;
        try {
            writer = new FileWriter(file);
            writer.write("www.twofire.com");
            writer.write("\r\n二火");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
