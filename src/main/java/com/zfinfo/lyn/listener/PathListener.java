package com.zfinfo.lyn.listener;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheEvent;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName : PathListener
 * @Description : 监听节点变化
 * @Author : Lyn
 * @CopyRight ZFINFO
 * @Date: 2020-10-12 10:59
 */
public class PathListener implements PathChildrenCacheListener {

    private static final Logger logger = LoggerFactory.getLogger(PathListener.class);
    @Override
    public void childEvent(CuratorFramework client, PathChildrenCacheEvent event) throws Exception {

        switch (event.getType()) {
            //必须异步模式 PathChildrenCache.StartMode.POST_INITIALIZED_EVENT
            case INITIALIZED:
                logger.info("子节点初始化成功");
                break;
            case CHILD_ADDED:
                logger.info("添加子节点路径: "+event.getData().getPath());
                logger.info("添加子节点数据: "+new String(event.getData().getData()));
                break;
            case CHILD_UPDATED:
                logger.info("修改子节点路径:" + event.getData().getPath());
                logger.info("修改子节点数据:" + new String(event.getData().getData()));
                break;
            case CHILD_REMOVED:
                logger.info("删除子节点:" + event.getData().getPath());
                break;
            case CONNECTION_LOST:
                logger.info("连接丢失");
                break;
            case CONNECTION_SUSPENDED:
                logger.info("连接被挂起");
                break;
            case CONNECTION_RECONNECTED:
                logger.info("恢复连接");
                break;
        }
    }
}
