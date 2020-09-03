package enums;

/**
 * 已读未读枚举
 *
 * @author Pan Juncai
 * @version 1.0
 * @date 2019/8/1 10:21
 */
public enum ReadStatusEnum {
    /**
     * 未读
     */
    UN_READ(0, "未读"),
    /**
     * 已读
     */
    HAS_READ(1, "已读"),
    ;
    /**
     * 类型
     */
    private int status;
    /**
     * 说明
     */
    private String desc;

    ReadStatusEnum(int status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
