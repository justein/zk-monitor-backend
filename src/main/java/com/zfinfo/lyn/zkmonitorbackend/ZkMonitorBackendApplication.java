package com.zfinfo.lyn.zkmonitorbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(value = "com.zfinfo")
@SpringBootApplication
public class ZkMonitorBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZkMonitorBackendApplication.class, args);
    }

}
