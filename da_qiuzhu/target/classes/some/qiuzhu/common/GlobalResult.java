package some.qiuzhu.common;

import some.qiuzhu.common.enums.GlobalResultCodeEnum;

/**
 * @author qiuzhu
 */
public class GlobalResult<T> {
    private T data;
    private String message;
    private int code;

    private GlobalResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> GlobalResult SUCCESS(T data) {
        return new GlobalResult(GlobalResultCodeEnum.SUCCESS.getCode(), "SUCCESS", data);
    }

    public static <T> GlobalResult SUCCESS(String message, T data) {
        return new GlobalResult(GlobalResultCodeEnum.SUCCESS.getCode(), message, data);
    }

    public static GlobalResult FAILURE(String message) {
        return new GlobalResult(GlobalResultCodeEnum.FAILURE.getCode(), message, null);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
