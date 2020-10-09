package com.zfinfo.lyn.utils;

import org.apache.curator.framework.CuratorFramework;

import java.util.List;

/**
 * @ClassName : ZKManager
 * @Description : 与Zookeeper通信的管理类
 * @Author : Lyn
 * @CopyRight ZFINFO
 * @Date: 2020-10-09 17:42
 */
public class ZKManager {

    private final CuratorFramework curatorFramework;


    public ZKManager(CuratorFramework curatorFramework) {
        this.curatorFramework = curatorFramework;
    }

    public CuratorFramework getCuratorFramework() {
        return this.curatorFramework;
    }

    public List<String> getChildren(String path) throws Exception {
//       return curatorFramework.getChildren().watched().forPath(path);
         return curatorFramework.getChildren().forPath(path);
    }
}
