package api;

/**
 * public static void sleep(long millis)
 *  使用该方法的当前线程睡眠millis秒
 */
public class SleepTest {
    public static void main(String[] args) {
        MyRun run = new MyRun();
        Thread thread = new Thread(run);
        thread.start();

        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + "====" + i);
            if (i == 2) {
                try {
                    thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
