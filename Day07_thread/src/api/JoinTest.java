package api;

/**
 * public final void join()
 *  调用join方法的线程被强制执行，其他线程处于阻塞态，该线程执行完后其他线程再执行
 */
public class JoinTest {
    public static void main(String[] args) {
        MyRun run = new MyRun();
        MyRun2 run2 = new MyRun2();
        Thread thread = new Thread(run);
        Thread thread2 = new Thread(run2);
        thread.start();
        thread2.start();

        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + "====" + i);
            if (i == 3) {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
