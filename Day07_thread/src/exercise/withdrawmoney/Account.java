package exercise.withdrawmoney;

public class Account {
    private double money; // 账户余额

    public Account() {
        money = 0;
    }

    public Account(double money) {
        this.money = money;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public void withdraw(double money) {};


}
