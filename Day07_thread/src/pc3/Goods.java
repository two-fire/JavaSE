package pc3;

public class Goods {
    private String brand;
    private String name;
    private boolean flag = false; // 默认无商品

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
        /**
         * 当生产者抢占到cpu资源，会判断当前对象是否有值。
         * 如果有意味着有商品，需要提醒消费者消费，同时当前线程进入阻塞状态，等待消费者取走商品之后再次生产；
         * 如果没有，不用进入阻塞状态，直接生产即可
         */
        if (flag) {
            try {
                wait(); // 导致当前线程等待，直到另一个线程调用该对象的notify()方法或notifyAll()方法
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.setBrand(brand);
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.setName(name);
        System.out.println("生产者生产了" + this.getBrand()
                + "----" + this.getName());
        flag = true;
        // 唤醒生产者去生产
        notify();
    }
    // 消费者获取产品
    public synchronized void get() {
        /**
         * 如果flag等于false，意味着生产者没有生产商品，此时消费者无法消费，需要让消费者线程进入阻塞状态，等待生产者生产。
         * 当有商品之后再开始消费
         */
        if (!flag) {
            try {
                wait(); // 其实是goods等着的
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("消费者取走了" + this.getBrand()
                + "----" + this.getName());
        // 如果代码执行到此处，意味着已经生产完成，需要将flag设置为true
        flag = false;
        // 唤醒消费者去消费 （其实是唤醒goods这个对象）
        notify();
    }
}
