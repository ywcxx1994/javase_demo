package com.yw.thread.blockqueue.delay;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayTask implements Delayed {
    String name;
    Long delayedTime;
    TimeUnit timeUnit;
    Long executeTime;

    public DelayTask(String name, Long delayedTime, TimeUnit timeUnit) {
        this.name = name;
        this.delayedTime = delayedTime;
        this.timeUnit = timeUnit;
        this.executeTime = System.currentTimeMillis()+timeUnit.toMillis(delayedTime);
    }
    @Override
    public long getDelay(TimeUnit unit) {
        return timeUnit.convert(executeTime - System.currentTimeMillis(),TimeUnit.MILLISECONDS);
    }

    /**
     * 按照时间正序排列
     * @param o
     * @return
     */
    @Override
    public int compareTo(Delayed o) {
        if(this.getDelay(TimeUnit.MILLISECONDS) > o.getDelay(TimeUnit.MILLISECONDS)) {
            return 1;
        }else if(this.getDelay(TimeUnit.MILLISECONDS) < o.getDelay(TimeUnit.MILLISECONDS)) {
            return -1;
        }
        return 0;
    }
}
