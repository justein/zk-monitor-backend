package com.zfinfo.lyn.mbean;

import javax.management.*;
import java.lang.management.ManagementFactory;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @ClassName : MBeanMain
 * @Description : MBean 测试吧
 * @Author : Lyn
 * @CopyRight ZFINFO
 * @Date: 2020-10-10 15:25
 */
public class MBeanMain {

    public static void main(String[] args) throws InterruptedException, MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException {
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        ObjectName objectName = new ObjectName("com.zfinfo.lyn.mbean:type=QueueSample");

        Queue<String> stringQueue = new ArrayBlockingQueue<>(10);

        stringQueue.add("request-header1");
        stringQueue.add("request-header2");
        stringQueue.add("request-header3");
        QueueSmapler queueSampler = new QueueSmapler(stringQueue);

        mBeanServer.registerMBean(queueSampler, objectName);

        System.out.println("Server started...");

        Thread.sleep(Long.MAX_VALUE);
    }
}
