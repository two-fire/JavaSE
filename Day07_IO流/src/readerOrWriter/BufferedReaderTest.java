package readerOrWriter;

import java.io.*;

/*
    public class BufferedReader extends Reader
    从字符输入流读取文本，缓冲字符，以提供字符，数组和行的高效读取
    BufferReader 比Reader类多了一个readLine方法（读取文本中一整行数据）
 */
public class BufferedReaderTest {
    public static void main(String[] args) {
//        1. 字节无法直接匹配字符
//        InputStream inputStream = null;

        // 2. read()字符读取
//        Reader reader = null;
        // 3. readline读取
        BufferedReader reader = null;
        try {
            // BufferedReader(Reader in) 创建使用默认大小的输入缓冲区的缓冲字符输入流。
//            inputStream = new BufferedReader(new FileReader("aaa.txt"));
            reader = new BufferedReader(new FileReader("aaa.txt"));
            // 2.
//            int read = reader.read();
//            System.out.println((char)read);
            String read = null;
            while ((read = reader.readLine())!= null) {
                System.out.println(read);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
