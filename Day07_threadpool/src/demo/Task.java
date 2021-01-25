package demo;

public class Task implements Runnable {
    @Override
    public void run() {
        // 加上sleep()，就不会出现线程的复用
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " running");
    }
}
