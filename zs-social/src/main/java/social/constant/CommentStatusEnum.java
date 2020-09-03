package social.constant;

/**评论状态的枚举
 * @author Pan Juncai
 * @version 1.0
 * @date 2019/7/17 15:42
 */
public enum CommentStatusEnum {
    /**
     * 已删除
     */
    HAS_DELETE(0, "已删除"),
    /**
     * 使用中
     */
    HAS_USING(1, "使用中"),
    /**
     * 已屏蔽
     */
    HAS_SHIELDING(2,"已屏蔽"),
    ;

    CommentStatusEnum(int status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    /**
     * 状态
     */
    private int status;
    /**
     * 说明
     */
    private String desc;

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
