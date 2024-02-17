package com.dujiangyan.tour_server.common;

/**
 * 返回工具类
 *
 * @author ame
 */
public class ResultUtils {

    /**
     * 成功
     */
    public static <T> BaseResponse<T> success(T data) {
        return new BaseResponse<>(0, data, "success");
    }

    /**
     * 成功
     * @param errorCode
     * @param data
     * @return
     * @param <T>
     */
    public static <T> BaseResponse<T> success(ErrorCode errorCode, T data) {
        return new BaseResponse<>(errorCode.getCode(), data, errorCode.getMessage());
    }

    /**
     * 失败
     *
     * @param errorCode
     * @return
     */
    public static BaseResponse error(ErrorCode errorCode) {
        return new BaseResponse<>(errorCode);
    }


    /**
     * 失败
     *
     * @param errorCode
     * @return
     */
    public static BaseResponse error(ErrorCode errorCode, String description) {
        return new BaseResponse<>(errorCode.getCode(), null, errorCode.getMessage(), description);
    }
}
