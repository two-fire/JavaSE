package demo;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolDemo2 {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
        System.out.println(System.currentTimeMillis());
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("1----延迟1s执行,每3s执行一次");
                System.out.println(System.currentTimeMillis());
            }
        }, 1, 3,TimeUnit.SECONDS) ;
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("2----延迟1s执行,每3s执行一次");
                System.out.println(System.currentTimeMillis());
            }
        }, 1, 3,TimeUnit.SECONDS);
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("3----延迟1s执行,每3s执行一次");
                System.out.println(System.currentTimeMillis());
            }
        }, 1, 3,TimeUnit.SECONDS);
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("4----延迟1s执行,每3s执行一次");
                System.out.println(System.currentTimeMillis());
            }
        }, 1, 3,TimeUnit.SECONDS);
//        scheduledExecutorService.shutdown();
    }
}
