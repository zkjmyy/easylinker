package com.wwh.iot.easylinker.constants;

/**
 * Created by wwhai on 2017/7/27.
 */
public enum ErrorMessage {
    ACTIVED("已经激活！"),
    ACTIVE_SUCCESS("激活成功！"),
    USER_LOCKED("用户被冻结！"),
    LOGOUT_SUCCESS("注销成功!"),
    LOGIN_SUCCESS("登录成功!"),
    LOGIN_FAILED("登录失败!"),
    REGISTER_SUCCESS("注册成功！"),
    REGISTER_FAILED("注册失败！"),
    USER_NOT_EXIST("用户不存在！"),
    NO_ACTIVE("账户没有激活！"),
    LOGIN_INVALID("请登录后操作!"),
    LOGIN_ERROR("登录出错!"),
    OPERATE_SUCCESS("操作成功!"),
    OPERATE_FAILED("操作失败!"),
    REQUIRED_APIKEY("没有APIKey"),
    FILE_DOWNLOAD_SUCCESS("文件下载成功!"),
    FILE_DOWNLOAD_FAILED("文件下载失败!"),
    TOPIC_EXIST("Topic已经存在，请不要重复添加！");
    private String message;

    private ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.getMessage();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
