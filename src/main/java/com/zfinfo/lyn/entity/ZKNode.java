package com.zfinfo.lyn.entity;

import java.util.Date;
import java.util.List;

/**
 * @ClassName : ZKNode
 * @Description : zookeeper 节点
 * @Author : Lyn
 * @CopyRight ZFINFO
 * @Date: 2020-10-12 13:58
 */
public class ZKNode {

    /**节点id*/
    private String id;
    /**全路径*/
    private String path;
    /**创建（create）该 znode 的 zxid*/
    private Long czxid;
    /**最后一次修改（modify）该 znode 的 zxid*/
    private Long mzxid;
    /**最后一次修改该 znode 子节点的 zxid*/
    private Long pzxid;

    /**创建该 znode 的时间*/
    private Long ctime;
    /**最后一次修改该 znode 的时间*/
    private Long ztime;
    /**该节点内容的版本，每次修改内容，版本都会增加*/
    private Integer dataVersion;
    /**该节点子节点的版本*/
    private Integer cversion;
    /**该节点的 ACL 版本*/
    private String aclVersion;
    /**如果该节点是临时节点（ephemeral node），会列出该节点所在客户端的 session id；如果不是临时节点，该值为 0*/
    private String ephemeralOwner;
    /**该节点存储的数据长度*/
    private Integer dataLength;
    /**该节点子节点的个数*/
    private Integer numChildren;

    private List<ZKNode> childrenNodes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Long getCzxid() {
        return czxid;
    }

    public void setCzxid(Long czxid) {
        this.czxid = czxid;
    }

    public Long getMzxid() {
        return mzxid;
    }

    public void setMzxid(Long mzxid) {
        this.mzxid = mzxid;
    }

    public Long getPzxid() {
        return pzxid;
    }

    public void setPzxid(Long pzxid) {
        this.pzxid = pzxid;
    }

    public Long getCtime() {
        return ctime;
    }

    public void setCtime(Long ctime) {
        this.ctime = ctime;
    }

    public Long getZtime() {
        return ztime;
    }

    public void setZtime(Long ztime) {
        this.ztime = ztime;
    }

    public Integer getDataVersion() {
        return dataVersion;
    }

    public void setDataVersion(Integer dataVersion) {
        this.dataVersion = dataVersion;
    }

    public Integer getCversion() {
        return cversion;
    }

    public void setCversion(Integer cversion) {
        this.cversion = cversion;
    }



    public String getEphemeralOwner() {
        return ephemeralOwner;
    }

    public void setEphemeralOwner(String ephemeralOwner) {
        this.ephemeralOwner = ephemeralOwner;
    }

    public Integer getDataLength() {
        return dataLength;
    }

    public void setDataLength(Integer dataLength) {
        this.dataLength = dataLength;
    }

    public Integer getNumChildren() {
        return numChildren;
    }

    public void setNumChildren(Integer numChildren) {
        this.numChildren = numChildren;
    }

    public List<ZKNode> getChildrenNodes() {
        return childrenNodes;
    }

    public void setChildrenNodes(List<ZKNode> childrenNodes) {
        this.childrenNodes = childrenNodes;
    }
}
