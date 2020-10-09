package com.zfinfo.lyn.utils;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.BackgroundCallback;
import org.apache.curator.framework.api.CuratorEvent;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

/**
 * @ClassName : CuratorUtils
 * @Description : 测试一下curator使用方法
 * @Author : Lyn
 * @CopyRight ZFINFO
 * @Date: 2020-10-09 16:38
 */
public class CuratorUtils {

    static  RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000,3);
    static CuratorFramework client = CuratorFrameworkFactory
            .newClient("127.0.0.1:2181",retryPolicy);

    static List<String> res = new ArrayList<>();

    public static List<String> getNode(String parentNode) throws Exception {
        List<String> tmpList = new ZKManager(client).getChildren(parentNode);
        for (String tmpPath:tmpList){
            String childNode = parentNode.equals("/") ? parentNode + tmpPath : parentNode + "/" + tmpPath;
            res.add(childNode);
            getNode(childNode);
        }
        return res;
    }

    public static void main(String[] args) throws InterruptedException {



        client.start();
//        Thread.sleep(5000);
        try {
            //创建一个空的节点
//            client.create().forPath("/empty");
//            //创建一个非空节点
//            client.create().forPath("/notEmpty","this is data".getBytes());
            //创建一个空的临时节点
            client.create().withMode(CreateMode.EPHEMERAL).forPath("/itsephNode");
            //创建一个非空的临时节点
            client.create().withMode(CreateMode.EPHEMERAL).forPath("/notEmEpNode","我是有数据的临时节点".getBytes());

            Thread.sleep(3000);
            //异步创建节点，指定线程池
            client.create().withMode(CreateMode.EPHEMERAL).inBackground(new BackgroundCallback() {
                @Override
                public void processResult(CuratorFramework curatorFramework, CuratorEvent curatorEvent) throws Exception {
                    System.out.println("当前线程："+Thread.currentThread().getName()
                            +"，code: "+curatorEvent.getResultCode()
                            +", type："+curatorEvent.getType());
                }
            },Executors.newFixedThreadPool(10)).forPath("/IamCreateByCustomThread");

            //异步创建节点，不指定线程池
            client.create().withMode(CreateMode.EPHEMERAL).inBackground(new BackgroundCallback() {
                @Override
                public void processResult(CuratorFramework curatorFramework, CuratorEvent curatorEvent) throws Exception {
                    System.out.println("当前线程："+Thread.currentThread().getName()
                            +"，code: "+curatorEvent.getResultCode()
                            +", type："+curatorEvent.getType());
                }
            }).forPath("/IamCreatedByZKThread");

            //获取节点内容

            byte[] nodeData = client.getData().forPath("/notEmpty");
            System.out.println("节点数据为："+new String(nodeData));
            Thread.sleep(20);

            //更新数据
            Stat stat = client.setData().forPath("/notEmpty");
            client.setData().withVersion(5).forPath("/notEmpty","shujuyijinggengxin".getBytes());
            //重新读取更新后的数据
            System.out.println("更新后的/empty节点数据为："+new String(client.getData().forPath("/notEmpty")));



            System.out.println("=======================================");
            System.out.println("获取所有节点内容：");
            System.out.println(getNode("/"));
            System.out.println("=======================================");

            Thread.sleep(10);

            //删除节点
            client.delete().forPath("/empty");

            Thread.sleep(20);
            //删除一个节点，并递归删除其所有子节点
            client.create().forPath("/AA");
            client.create().forPath("/AA/bb");
            client.create().forPath("/AA/cc");
            client.delete().deletingChildrenIfNeeded().forPath("/AA");
            //注意:由于一些网络原因,上述的删除操作有可能失败,使用guaranteed(),
            // 如果删除失败,会记录下来,只要会话有效,就会不断的重试,直到删除成功为止
            client.delete().guaranteed().forPath("/itsephNode");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
