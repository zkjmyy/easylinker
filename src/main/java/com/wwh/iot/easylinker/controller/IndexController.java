package com.wwh.iot.easylinker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/7/27.
 */
@Controller
@RequestMapping("/")
public class IndexController {
    public  String index(){
        return "index";
    }
}
