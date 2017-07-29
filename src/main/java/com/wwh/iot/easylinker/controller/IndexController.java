package com.wwh.iot.easylinker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wwhai on 2017/7/27.
 */

/**
 * 首页控制器
 */
@Controller
@RequestMapping("/")
public class IndexController {
    @RequestMapping("/loginPage")
    public String loginPage() {
        return "loginPage";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

}
