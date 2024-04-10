package com.github.jianlu8023.utils.format.response;

public enum ResponseStatus {

    SUCCESS(200, "操作成功"),

    FAILURE(201, "操作失败"),

    ERROR(506, "系統異常，請稍後重試"),
    INTERNAL_SERVER_ERROR(500, "服務器異常"),
    METHOD_IMPLEMENTED(501, "請求方法未實現"),
    BAD_GATEWAY(502, "無效相應"),
    BAD_REQUEST(400, "請求錯誤"),

    PARAM_ERROR(1000, "参数异常"),

    INVALID_TOKEN(2001, "访问令牌不合法"),
    ACCESS_DENIED(2002, "没有权限访问该资源");


    private String message;

    private Integer code;

    ResponseStatus(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }

    /**
     * Returns the name of this enum constant, as contained in the
     * declaration.  This method may be overridden, though it typically
     * isn't necessary or desirable.  An enum type should override this
     * method when a more "programmer-friendly" string form exists.
     *
     * @return the name of this enum constant
     */
    @Override
    public String toString() {
        return super.toString();
    }
}
