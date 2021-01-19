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
 *
 * 存在问题：每次读取一个字节效率低。需要循环N多次
 */
public class InputStreamDemo2 {
    public static void main(String[] args) {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream("abc.txt");
            int length = 0; //存返回值：下一个数据字节；如果到达流的末尾，则返回 -1
            // 循环读取所有字节
            while ((length = inputStream.read()) != -1) {
                System.out.println((char)length);
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
