package readerOrWriter;

import java.io.*;

/*
    public class BufferedWriter extends Writer
    将文本写入字符输出流，缓冲字符，以提供单个字符，数组和字符串的高效写入
 */
public class BufferedWriterTest {
    public static void main(String[] args) {
        BufferedWriter bufferedWriter = null;
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(new File("abc.txt"));
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("mashibing"); // 写，返回值是null
            bufferedWriter.newLine(); // 换行
            bufferedWriter.append("m马士兵"); // 追加,返回值是Writer
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

