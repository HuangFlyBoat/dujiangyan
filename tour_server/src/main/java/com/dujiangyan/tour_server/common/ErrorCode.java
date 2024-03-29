package com.dujiangyan.tour_server.common;

/**
 * 全局错误码
 */
public enum ErrorCode {

    SUCCESS(0, "success", ""),
    PARAMS_ERROR(40000, "请求参数错误", ""),
    NULL_ERROR(400001, "请求数据为空", ""),
    NOT_LOGIN(40100, "NOT LOGIN", ""),
    REGISTER_ERROR(40002, "注册失败", ""),
    LOGIN_ERROR(40003, "登录失败", ""),
    NO_AUTH(40101, "无权限", ""),

    FILE_TOO_LARGE(40005, "文件过大", ""),

    EDIT_ERROR(40004, "编辑失败", ""),

    UPLOAD_ERROR(40006, "上传失败", ""),
    //屏蔽了所有的服务器的报错
    SYSTEM_ERROR(50000, "系统内部异常", "");


    private final int code;

    /**
     * 状态码信息
     */
    private final String message;

    /**
     * 状态码描述（详情）
     */
    private final String description;

    ErrorCode(int code, String message, String description) {
        this.code = code;
        this.message = message;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getDescription() {
        return description;
    }
}
