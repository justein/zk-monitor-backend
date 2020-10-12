package com.zfinfo.lyn.utils;

import com.zfinfo.lyn.listener.PathListener;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * @ClassName : ZKWatcherDemo
 * @Description :
 * @Author : Lyn
 * @CopyRight ZFINFO
 * @Date: 2020-10-12 10:40
 */
public class ZKWatcherDemo {

    private static final String PATH = "/";

    static RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
    static CuratorFramework client = CuratorFrameworkFactory.newClient("127.0.0.1:2181",retryPolicy);

    static PathChildrenCache pathChildrenCache = new PathChildrenCache(client,PATH,true);

    public static void main(String[] args) throws Exception {

        client.start();
        pathChildrenCache.start();
        pathChildrenCache.getListenable().addListener(new PathListener());

        Thread.sleep(Integer.MAX_VALUE);

    }
}
