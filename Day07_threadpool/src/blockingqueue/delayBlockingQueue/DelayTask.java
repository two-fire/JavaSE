package blockingqueue.delayBlockingQueue;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

class DelayTask implements Delayed {
    public String name;
    public Long delayTime; // 延迟时间
    public TimeUnit delayTimeUnit; // 延时时间单位
    public Long executeTime;//ms

    DelayTask(String name, long delayTime, TimeUnit delayTimeUnit) {
        this.name = name;
        this.delayTime = delayTime;
        this.delayTimeUnit = delayTimeUnit;
        this.executeTime = System.currentTimeMillis() + delayTimeUnit.toMillis(delayTime);
    }


    // 如果不大于0，不能进行延时执行
    @Override
    public int compareTo(Delayed o) {
        if(this.getDelay(TimeUnit.MILLISECONDS) > o.getDelay(TimeUnit.MILLISECONDS)) {
            return 1;
        }else if(this.getDelay(TimeUnit.MILLISECONDS) < o.getDelay(TimeUnit.MILLISECONDS)) {
            return -1;
        }
        return 0;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(executeTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }
}
