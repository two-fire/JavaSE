package exercise.withdrawmoney;

public class Zhangsan2 implements Runnable {
    private Account account;
    private double withdraw;

    public Zhangsan2() {
        account = new Account();
        withdraw = 0;
    }

    public Zhangsan2(Account account, double withdraw) {
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
            withdraw();
        }
    }

    public synchronized void withdraw() {
        if (account.getMoney() >= withdraw) {
            System.out.println(Thread.currentThread().getName() + " 准备取款");
            account.setMoney(account.getMoney() - withdraw);
            System.out.println(Thread.currentThread().getName() + " 完成取款");
        } else {
            System.out.println("余额不足以支付 " + Thread.currentThread().getName() + " 的取款，余额为"
                    + account.getMoney());
        }
    }

    public static void main(String[] args) {
        Account account = new Account(100); // 账户余额为100
        Zhangsan2 zhangsan = new Zhangsan2(account, 20);
        Thread t1 = new Thread(zhangsan, "张三");
        Thread t2 = new Thread(zhangsan, "张三的妻子");

        t1.start();
        t2.start();
    }
}
