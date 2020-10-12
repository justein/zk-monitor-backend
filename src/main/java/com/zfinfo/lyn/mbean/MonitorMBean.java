package com.zfinfo.lyn.mbean;

public interface MonitorMBean {

    public void sayHello();
    public int add(int x, int y);

    /**name被定义为只读属性*/
    public String getName();

    /**缓存大小被定义为可读写属性*/
    public int getCacheSize();
    public void setCacheSize(int size);

}
