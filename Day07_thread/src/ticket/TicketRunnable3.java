package ticket;

public class TicketRunnable3 implements Runnable{
    private int ticket = 5; // 一共5张票
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            /** this的意思是sale()已经属于TicketRunnable3这个对象了，而不归于整个类了
             *  this代表的就是synchronized的锁的对象
             */
           this.sale();
        }
    }

    /**
     * 使用同步方法解决多线程数据安全性问题
     */
    public synchronized void sale() {
        if (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + "正在出售第" + (ticket--) + "张票");
        }
    }


    public static void main(String[] args) {
        TicketRunnable3 ticket = new TicketRunnable3();

        Thread t1 = new Thread(ticket,"A"); // 线程名称A
        Thread t2 = new Thread(ticket,"B");
        Thread t3 = new Thread(ticket,"C");
        Thread t4 = new Thread(ticket,"D");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
