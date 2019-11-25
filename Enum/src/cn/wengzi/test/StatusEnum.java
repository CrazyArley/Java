package cn.wengzi.test;

/**
 * @author leizige
 * @date 19/11/25 23:19 night
 */
public enum StatusEnum {


    LOCK("锁定", 0),

    UNLOCK("解锁", 1);

    private String statusName;
    private Integer statusCode;

    private StatusEnum(String statusName, Integer statusCode) {
        this.statusName = statusName;
        this.statusCode = statusCode;
    }

    public Integer getStatusCode() {
        return this.statusCode;
    }


}
