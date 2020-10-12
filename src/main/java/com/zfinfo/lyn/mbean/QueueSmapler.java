package com.zfinfo.lyn.mbean;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Queue;

/**
 * @ClassName : QueueSmapler
 * @Description :
 * @Author : Lyn
 * @CopyRight ZFINFO
 * @Date: 2020-10-10 16:13
 */
public class QueueSmapler implements QueueSampleMXBean {
    private Queue<String> stringQueue;

    public QueueSmapler(Queue<String> stringQueue) {
        this.stringQueue = stringQueue;
    }

    @Override
    public QueueSample getQueueSamples() {
        return new QueueSample(LocalDate.now(),stringQueue.peek(),stringQueue.size());
    }

    @Override
    public void clearQueue() {
        stringQueue.clear();
    }
}
