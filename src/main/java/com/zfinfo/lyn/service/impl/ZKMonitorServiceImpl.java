package com.zfinfo.lyn.service.impl;

import com.sun.org.apache.bcel.internal.generic.LSTORE;
import com.zfinfo.lyn.config.ZKClient;
import com.zfinfo.lyn.constants.ZKConstant;
import com.zfinfo.lyn.entity.TreeNode;
import com.zfinfo.lyn.entity.ZKNode;
import com.zfinfo.lyn.service.ZKMonitorService;
import com.zfinfo.lyn.utils.CuratorUtils;
import org.apache.curator.framework.recipes.cache.TreeCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * @ClassName : ZKMonitorServiceImpl
 * @Description :
 * @Author : Lyn
 * @CopyRight ZFINFO
 * @Date: 2020-10-12 14:15
 */

@Service
public class ZKMonitorServiceImpl implements ZKMonitorService {

    @Autowired
    private ZKClient zkClient;
    @Override
    public void getZKState() {

    }

    @Override
    public List<TreeNode> getZKNodeTree(String zkNodePath) throws Exception {

        return getZKNodesAndPath(zkNodePath);
    }

    /**回调模式有问题，map会清空.改为使用静态函数实现，返回全路径后，内存组装树结构*/
    /**前端改为异步构造树算了，简单直接*/
    private List<TreeNode> getZKNodesAndPath(String parentNode) throws Exception {
        List<TreeNode> treeNodes = new ArrayList<>();
        List<String> tmpList = zkClient.getClient().getChildren().forPath(parentNode);
        if (!CollectionUtils.isEmpty(tmpList)) {
            for (int i = 0; i < tmpList.size(); i++) {
                TreeNode treeNode = new TreeNode();
                treeNode.setTitle(tmpList.get(i));
                treeNode.setExpanded(false);
                treeNode.setSelected(false);
                treeNodes.add(treeNode);
            }

        }
//        List<String> tmpList = zkClient.getClient().getChildren().forPath(parentNode);
//        List<ZKNode> zkNodeList = new ArrayList<>();
//
//        if (!CollectionUtils.isEmpty(tmpList)){
//            int tmpListLength = tmpList.size();
//            for (int i =0; i< tmpListLength; i++) {
//                /**如果是根节点*/
//                if (ZKConstant.ROOT_PATH.equals(parentNode)) {
//                    parentNode = parentNode + tmpList.get(i);
//                    /**非根节点*/
//                }else {
//                    parentNode = parentNode + ZKConstant.ROOT_PATH+tmpList.get(i);
//                }
//
//                nodeMap.put(currentNode, tmpList);
//
//                getZKNodesAndPath(parentNode);
//            }
//        }
//
//
//        return nodeMap;
//        List<String> strings =  CuratorUtils.getNode(zkClient.getClient(),ZKConstant.ROOT_PATH);
//        TreeCache treeCache = new TreeCache(zkClient.getClient(),"/");
//        String str =  TreeCache.newBuilder(zkClient.getClient(),"/").toString();
//        System.out.println(str);
        /**1、先构造成树结构，返回给前端
         * 2、页面点击具体节点时，再按选中节点查询stat返回
         * 3、
         * */
        return treeNodes;
    }

}
