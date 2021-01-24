package demo;

/**
 * 实现多线程的时候：
 *  1. 必须继承Thread类
 *  2. 必须重写run方法，指核心执行逻辑
 *  3. 线程启动时，不要直接调用run方法，而是用start()调用
 *  4. 每次运行相同代码，出来结果可能不一样
 *
 * 第二种实现方式：使用了代理设计模式
 *  1. 实现Runnable接口
 *  2. 重写run方法
 *  3. 创建Thread对象，将刚刚创建好的runnable的子类实现作为Thread的构造参数
 *  4. 通过thread.start()启动
 *
 * 线程的生命周期：
 *  1. 新生状态：当创建好线程对象后，没有启动之前（调用start方法之前）
 *      ThreadDemo = new ThreadDemo();
 *      RunnableDemo = new RunnableDemo;
 *  2. 就绪状态：准备开始执行，并没有执行。表示调用start方法之后
 *      当对应的线程创建完成，且调用start方法后，所有的线程会添加到一个就绪队列中，所有线程同时去抢占cpu资源
 *  3. 运行状态：当前进程获取到cpu资源后，就绪队列中所有的线程会去抢占cpu资源，谁先抢占到谁先执行。在执行的过程就称为运行状态
 *      抢占cpu资源，执行代码逻辑开始
 *  4. 死亡状态：当运行的进程正常执行完所有的代码逻辑或者因为异常终止程序叫做死亡状态
 *      进入方式：
 *       - 正常运行完成且结束
*        - 人为中断执行，如使用stop()
 *       - 程序抛出未捕获的异常
 *  5. 阻塞状态：在程序运行过程中，发生某些异常情况导致当前线程无法再顺利进行下去，此时会进入阻塞状态。进入阻塞状态的原因消除
 *              之后，所有的阻塞队列会再次进入到就绪状态中，随机抢占cpu资源，等待执行
 *      进入方式：
 *       - sleep方法
 *       - 等待I/O设备等资源
 *       - join方法（代码中执行的逻辑）
 *  注意：
 *      在多线程的时候，可以实现唤醒和等待的过程，但是唤醒和等待操作的对应不是Thread类，
 *          而是我们设置的共享对象或者共享变量
 *  多线程并发访问的时候会出现数据安全问题
 *      解决方法：
 *          1. 同步代码块
 *              Synchronized(共享资源，共享对象，需要是object的子类) {具体执行的代码}
 *          2. 同步方法
 *              将核心代码逻辑定义成一个方法，使用synchronized关键字
 */
public class ThreadDemo extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "------"+ i);
        }
    }

    public static void main(String[] args) {
        ThreadDemo threadDemo = new ThreadDemo();
        threadDemo.start();
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "====="+ i);
        }
    }
}
