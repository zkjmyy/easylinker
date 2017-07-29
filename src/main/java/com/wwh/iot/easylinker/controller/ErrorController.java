package com.wwh.iot.easylinker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wwhai on 2017/7/29.
 */
@Controller
@RequestMapping("/")
public class ErrorController {
    @RequestMapping("/404")
    public String error404() {
        return "error/404";

    }

    @RequestMapping("/500")
    public String error500() {
        return "error/500";

    }
}
