package enums;

/**
 * app用户状态枚举类
 *
 * @author Pan Juncai
 * @version 1.0
 * @date 2019/7/26 10:37
 */
public enum UserStatusEnum {
    /**
     * 新用户
     */
    NEW_USER(0, "新用户"),
    /**
     * 正常用户
     */
    NORMAL_USER(0, "正常用户"),
    /**
     * 冻结用户
     */
    FROZEN_USER(0, "冻结用户"),
    ;
    /**
     * 状态
     */
    private int status;
    /**
     * 说明
     */
    private String desc;

    UserStatusEnum(int status, String desc) {
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
