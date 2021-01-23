package api;

/**
 * public static void yield()：
 *  当前执行的线程暂停一次，允许其他线程执行，不阻塞，线程进入就绪态。
 *  如果没有其他等待线程，这时当前线程会马上恢复执行。
 *      只是让出一次，该线程依然会跑到就绪队列中进行cpu抢占
 * public final void stop()：
 *  强制结束正在运行的线程
 */
public class YieldTest {
    public static void main(String[] args) {
        MyRun run = new MyRun();
        Thread thread = new Thread(run);
        thread.start();

        for (int i = 0; i < 5; i++) {
            if (i == 2) {
//                Thread.yield();
                // 过时方法 当前线程强制结束
                thread.stop();
                System.out.println(Thread.currentThread().getName() + "====" + i + "礼让一次");
            } else {
                System.out.println(Thread.currentThread().getName() + "----" + i);
            }
        }
    }
}
