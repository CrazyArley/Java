package cn.wengzi.use.util;


public enum CommonPostCode {

    PARAM_NULL(-1, "param required"),
    PARAM_LENGTH(-2, "param too long");

    private int errorCode;

    private String errorMessage;


    private CommonPostCode(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }


}