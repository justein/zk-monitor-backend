package com.zfinfo.lyn.service;

import com.zfinfo.lyn.entity.TreeNode;
import com.zfinfo.lyn.entity.ZKNode;

import java.util.List;
import java.util.Map;

/**
 * @ClassName : ZKMonitorService
 * @Description : zk监控核心逻辑
 * @Author : Lyn
 * @CopyRight ZFINFO
 * @Date: 2020-10-12 09:44
 */
public interface ZKMonitorService {

    public void getZKState();

    public List<TreeNode> getZKNodeTree(String zkNodePath) throws Exception;
}
