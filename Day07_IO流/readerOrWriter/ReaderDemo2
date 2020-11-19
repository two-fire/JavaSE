package readerOrWriter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ReaderDemo2 {
    public static void main(String[] args) {
        Reader reader = null;
        try {
            reader = new FileReader("abc.txt");
            int read = 0;
            while ((read = reader.read()) != -1) {
                System.out.println((char)read);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
