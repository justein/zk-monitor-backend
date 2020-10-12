package com.zfinfo.lyn.mbean;

import java.beans.ConstructorProperties;
import java.sql.Date;
import java.time.LocalDate;

/**
 * @ClassName : QueueSample
 * @Description : Queue 采样数据
 * @Author : Lyn
 * @CopyRight ZFINFO
 * @Date: 2020-10-10 16:03
 */
public class QueueSample {

    private LocalDate enQueueTime;
    private String header;
    private int queueSize;

    @ConstructorProperties({"enQueueTime","header", "queueSize"})
    public QueueSample(LocalDate enQueueTime, String header, int queueSize) {
        this.enQueueTime = enQueueTime;
        this.header = header;
        this.queueSize = queueSize;
    }

    public LocalDate getEnQueueTime() {
        return enQueueTime;
    }

    public String getHeader() {
        return header;
    }

    public int getQueueSize() {
        return queueSize;
    }
}
