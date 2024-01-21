package some.qiuzhu.common.enums;

public enum GlobalResultCodeEnum {
    SUCCESS(1000),
    FAILURE(2000);

    private int code;

    private GlobalResultCodeEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
