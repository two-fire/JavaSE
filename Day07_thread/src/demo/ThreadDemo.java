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
 *  5. 阻塞状态：在程序运行过程中，发生某些异常情况导致当前线程无法再顺利进行下去，此时会进入阻塞状态。进入阻塞状态的原因消除
 *              之后，所有的阻塞队列会再次进入到就绪状态中，随机抢占cpu资源，等待执行
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
