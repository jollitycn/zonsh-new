package enums;

/**
 * @author Pan Juncai
 * @version 1.0
 * @date 2019/7/30 16:23
 */
public enum FollowStatusEnum {
    /**
     * 未关注
     */
    UN_FOLLOW(0,"未关注"),
    /**
     * 已关注
     */
    IS_FOLLOW(1,"已关注"),
    /**
     * 相互关注
     */
    TOGETHER_FOLLOW(2,"相互关注"),
    ;

    /**
     * 状态
     */
    private int status;
    /**
     * 说明
     */
    private String desc;

    FollowStatusEnum(int status, String desc) {
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
