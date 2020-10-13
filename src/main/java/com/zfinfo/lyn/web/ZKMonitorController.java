package com.zfinfo.lyn.web;

import com.zfinfo.lyn.service.ZKMonitorService;
import com.zfinfo.lyn.utils.GsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName : ZKMonitorController
 * @Description : zookeeper监控
 * @Author : Lyn
 * @CopyRight ZFINFO
 * @Date: 2020-10-12 09:40
 */
@RestController
@RequestMapping("/zkmonitor")
public class ZKMonitorController {

    @Autowired
    private ZKMonitorService zkMonitorService;

    @GetMapping("/allzkNodes")
    public void getZKNodes(@RequestParam("zkNodePath") String zkNodePath, HttpServletResponse response) throws Exception {

        response.getWriter().print(GsonUtils.toJson(zkMonitorService.getZKNodeTree(zkNodePath)));
    }
}
