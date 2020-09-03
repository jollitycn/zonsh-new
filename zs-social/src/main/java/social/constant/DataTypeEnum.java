package social.constant;

/**
 * 数据类型枚举
 *
 * @author Pan Juncai
 * @version 1.0
 * @date 2019/7/17 15:38
 */
public enum DataTypeEnum {
    /**
     * 一级评论
     */
    LEVEL_ONE_COMMENT(1, "一级评论"),
    /**
     * 二级评论
     */
    LEVEL_TWO_COMMENT(2, "二级评论"),
    /**
     * 回复
     */
    REPLY_COMMENT(3, "回复"),
    ;

    DataTypeEnum(int type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    /**
     * 类型
     */
    private int type;
    /**
     * 说明
     */
    private String desc;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
