package demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Executor是所有要执行线程的一个父类，是一个接口
 * ExecutorService是继承于Executor的子接口
 */
public class CacheThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        // ExecutorService从Executor 继承来的方法
        for (int i = 0; i < 20; i++) {
            executorService.execute(new Task());
        }
        // 启动有序关闭，其中先前提交的任务将被执行，但不会接受任何新任务。 如果已经关闭，调用没有额外的作用
        executorService.shutdown();
    }
}
