package pc3;

/**
 * 多线程访问的时候，出现了数据安全的问题：
 *  1. 生产者没有生产产品，消费者就可以获取
 *  2. “旺仔---矿泉水”出现品牌名称不匹配情况
 *
 *  pc3 解决了问题1
 */
public class Test {
    public static void main(String[] args) {

        Goods goods = new Goods();

        Producer producer = new Producer(goods);
        Consumer consumer = new Consumer(goods);

        Thread t1 = new Thread(producer);
        Thread t2 = new Thread(consumer);
        t1.start();
        t2.start();
    }
}
