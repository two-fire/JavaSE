package exercise.withdrawmoney;

/**
 * 需求：
 *  张三和妻子各有一张银行卡和存折，可同时对一个账户进行存取款操作。
 *  请使用多线程及同步方法模拟张三和妻子同时取款过程。
 * 分析：
 *  定义Account类表示银行账户
 *  定义两个线程分别实现张三和妻子取款操作
 */
public class Zhangsan implements Runnable{

    private Account account;
    private double withdraw;

    public Zhangsan() {
        account = new Account();
        withdraw = 0;
    }

    public Zhangsan(Account account, double withdraw) {
        this.account = account;
        this.withdraw = withdraw;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (this) {
                if (account.getMoney() >= withdraw) {
                    System.out.println(Thread.currentThread().getName() + " 准备取款");
                    account.setMoney(account.getMoney() - withdraw);
                    System.out.println(Thread.currentThread().getName() + " 完成取款");
                } else {
                    System.out.println("余额不足以支付 " + Thread.currentThread().getName() + " 的取款，余额为"
                            + account.getMoney());
                }
            }
        }
    }

    public static void main(String[] args) {
        Account account = new Account(100); // 账户余额为100
        Zhangsan zhangsan = new Zhangsan(account, 20);
        Thread t1 = new Thread(zhangsan, "张三");
        Thread t2 = new Thread(zhangsan, "张三的妻子");

        t1.start();
        t2.start();
    }
}
