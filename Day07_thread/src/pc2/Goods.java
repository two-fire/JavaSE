package pc2;

public class Goods {
    private String brand;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    // 生产者生产产品
    public synchronized void set(String brand, String name) {
        this.setBrand(brand);
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.setName(name);
        System.out.println("生产者生产了" + this.getBrand()
                + "----" + this.getName());
    }
    // 消费者获取产品
    public synchronized void get() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("消费者取走了" + this.getBrand()
                + "----" + this.getName());
    }
}
