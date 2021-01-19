package readerOrWriter;

import java.io.*;

/**
 * 字符文件流复制图片后不能直接打开，会出问题
 * 处理图片、视频，其他文件格式的时候，最好还是使用字节流处理。
 */
public class CopyPicture {
    public static void main(String[] args) {
//        FileReader reader = null;
//        FileWriter writer = null;
//        try {
//            reader = new FileReader("1.png");
//            writer = new FileWriter("2.png");
//
//            int length = 0;
//            char[] chars = new char[1024];
//            while ((length = reader.read(chars)) != -1) {
//                writer.write(chars);
//            }
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                writer.close();
//                reader.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        try {
            fileInputStream = new FileInputStream("1.png");
            fileOutputStream = new FileOutputStream("3.png");

            int length = 0;
            byte[] buffer = new byte[1024];
            while ((length = fileInputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
