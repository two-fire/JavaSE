import java.io.File;
import java.io.IOException;

/**
 * File类提供了对当前文件系统中文件的部分操作
 */
public class FileDemo {
    public static void main(String[] args) throws IOException {
        File file = new File("abc.txt"); // 跟src平级

        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 判断文件的属性，返回布尔值
//        System.out.println(file.canExecute());
//        file.canRead();
//        file.canWrite();

        // 当前文件是否存在
        System.out.println(file.exists());

        // 获取文件名称
        System.out.println(file.getName());
        // 当前文件绝对路径
        System.out.println(file.getAbsolutePath());
        // 文件父路径名称，如果文件路径中只包含文件名称，则显示null
        System.out.println(file.getParent());
        // 返回文件绝对路径的规范形式
        System.out.println(file.getCanonicalPath());
        // 返回操作系统的文件分隔符
        System.out.println(File.separator);

        // 无论当前路径是否存在，只要给定具体路径，都可以返回相应路径名称
        File file2 = new File("D:/test.txt");
        System.out.println(file2.getAbsolutePath()); // D:\test.txt


        // 判断文件还是目录
        System.out.println(file2.isDirectory()); // false
        System.out.println(file2.isFile()); // false

        File file3 = new File("c:/");
        String[] list = file3.list();
        for (String str : list) {
            System.out.println(str);
        }
        System.out.println("------------------");
        File[] files = file3.listFiles();
        for (File f : files) {
            System.out.println(f);
        }

        // 打印当前文件系统的盘符
        File[] files1 = File.listRoots();
        for (int i = 0; i < files1.length; i++) {
            System.out.println(files1[i]);
        } // C:\  D:\

        // 创建单级目录
        File file4 = new File("c:/a");
        file4.mkdir();
        // 创建多级目录
        File file5 = new File("c:/a/b");
        file5.mkdirs();

        // 循环遍历输出c盘所有文件的绝对路径
        // 递归
        File file6 = new File("d:/txt");
        printFile(file6);

    }

    /**
     * 文件在遍历时会出现空指针异常问题，原因在于当前文件系统受保护，某些文件没有访问权限
     * @param file
     */
    public static void printFile(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f:files) {
                printFile(f);
            }
        } else {
            System.out.print("此文件是一个具体文件，只有一个文件名称");
            System.out.println(file.getAbsolutePath());
        }
    }
}

