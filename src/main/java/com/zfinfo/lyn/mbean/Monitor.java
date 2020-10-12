package com.zfinfo.lyn.mbean;

/**
 * @ClassName : Monitor
 * @Description : 监控实现类
 * @Author : Lyn
 * @CopyRight ZFINFO
 * @Date: 2020-10-10 15:34
 */
public class Monitor implements MonitorMBean {

    private static final int DEFAULT_CACHE_SIZE = 200;
    private int cacheSize = DEFAULT_CACHE_SIZE;
    @Override
    public void sayHello() {
        System.out.println("Hello ,Welcome to here.");
    }

    @Override
    public int add(int x, int y) {
        return x + y;
    }

    @Override
    public String getName() {
        return "我的名字叫 Lyn 神";
    }

    @Override
    public int getCacheSize() {
        return cacheSize;
    }

    @Override
    public void setCacheSize(int size) {
        this.cacheSize = size;
        System.out.println("Cache size now " + this.cacheSize);
    }
}
