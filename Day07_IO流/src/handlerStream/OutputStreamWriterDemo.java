package handlerStream;

import java.io.*;

/**
 * OutputStreamWriter 是字符流通向字节流的桥梁
 */
public class OutputStreamWriterDemo {
    public static void main(String[] args) {

        File file = new File("avc.txt");
        // 写的时候的处理流
        OutputStreamWriter outputStreamWriter = null;
        FileOutputStream fileOutputStream = null;

        try {
//            long time = System.currentTimeMillis();
            fileOutputStream = new FileOutputStream(file);
            outputStreamWriter = new OutputStreamWriter(fileOutputStream, "gbk");
            outputStreamWriter.write(99);
            outputStreamWriter.write("土家族民族自治区");
            outputStreamWriter.write("abcdefg",0,5);
//            long end = System.currentTimeMillis();
//            System.out.println(end-time);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭流对象时候建议按照创建时的逆序关闭
            try {
                outputStreamWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
