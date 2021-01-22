/**
 * 介绍线程类的Api方法
 */
public class ThreadApiDemo implements Runnable{
    public static void main(String[] args) {
        // 获取当前线程对象
        Thread thread = Thread.currentThread();
        // 获取当前线程的名称
        System.out.println(thread.getName());
        // 获取线程的ID
        System.out.println(thread.getId());
        // 获取线程的优先级,在一般系统中，范围是0~10的值，默认值5.有些系统是0~100
        System.out.println(thread.getPriority());
        // 设置线程池的优先级
        /**
         * 优先级越高，一定越先执行吗？
         *  不。优先级只能反映线程执行紧急程度 , 不能决定是否一定先执行
         */
        thread.setPriority(1);
        System.out.println(thread.getPriority());

        ThreadApiDemo threadApiDemo = new ThreadApiDemo();
        Thread t1 = new Thread(threadApiDemo);
        t1.setPriority(9);
        System.out.println(t1.getName() +","+ t1.getId() +","+ t1.getPriority());
        System.out.println(thread.getName() +","+ thread.getId() +","+ thread.getPriority());
        // 判断线程是否存活
        System.out.println(t1.isAlive());
        t1.start();
//        for (int i = 0; i < 5; i++) {
//            System.out.println(Thread.currentThread().getName() + "----" + i);
//        }
        System.out.println(t1.isAlive());
    }

    @Override
    public void run() {
//        for (int i = 0; i < 5; i++) {
//            System.out.println(Thread.currentThread().getName() + "----" + i);
//        }
    }
}
