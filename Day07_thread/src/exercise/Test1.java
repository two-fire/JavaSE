package exercise;

/**
 * 要求：
 *  A,B两个线程，分别打印整数1到10和10到1，交替输出。
 * 注意：
 *  如果睡眠时间相同会失败。因为如果同时睡，会导致同时醒，仍然有竞争。
 *  可以利用时间差:
 *      1. t.start();和主线程循环之间加上足够大的for循环
 *      2. 睡眠时间人为设置时间差
 */
public class Test1 implements Runnable {
    @Override
    public void run() {
        for (int i = 10; i > 0; i--) {
            System.out.println(Thread.currentThread().getName() + "====" + i);
            try {
                Thread.sleep(1001);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {

        Thread t = new Thread(new Test1());
        t.start();
//        for (int i = 0; i < 100000000; i++) { }
        for (int i = 1; i < 11; i++) {
            System.out.println(Thread.currentThread().getName() + "----" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
