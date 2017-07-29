package com.wwh.iot.easylinker.except;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by wwhai on 2017/7/28.
 */

/**
 * 系统默认异常信息处理
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 系统异常处理，比如：404,500
     *
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public JSONObject defaultErrorHandler(Exception e) throws Exception {
        JSONObject resultJson = new JSONObject();
        if (e instanceof org.springframework.web.servlet.NoHandlerFoundException) {
            resultJson.put("state", 0);
            resultJson.put("message", "404你懂得!");
        } else {
            resultJson.put("state", 0);
            e.printStackTrace();
            logger.info(e.getMessage());
            resultJson.put("message", "500你懂得!");
        }
        return resultJson;
    }
}
