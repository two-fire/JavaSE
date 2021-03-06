package Stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 流表示一个文件将数据返送到另一个文件，包含一个流向的问题
 *      当前所写的代码作为参照物
 *          从一个文件中读取数据到程序叫输入流
 *          从程序写入文件叫输出流
 *
 * 注：每次编写IO流的时候一定要注意关闭流
 *
 * 步骤：
 *      1. 选择合适的IO流对象
 *      2. 创建对象
 *      3. 传输数据
 *      4. 关闭流对象
 */
public class InputStreamDemo4 {
    public static void main(String[] args) {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream("abc.txt");
            int length = 0; // 存读取到缓冲区的总字节数
            // 添加缓冲区方式进行读取，每次将数据添加到缓冲区，满了之后一次读取，而不是每个字节读取
            byte[] buffer = new byte[1024];
            //  第一个字节读取存储在元素b[off]…这些字节将存储在元素b[off]至b[off+ k -1]
            while ((length = inputStream.read(buffer,1020,2)) != -1) {
                System.out.println(new String(buffer, 1020, length));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
