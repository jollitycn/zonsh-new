package enums;

/**
 * 数据来源枚举
 *
 * @author Pan Juncai
 * @version 1.0
 * @date 2019/7/17 15:24
 */
public enum SourceTypeEnum {
    /**
     * 无
     */
    NONE(0, "无"),
    /**
     * 来源回答
     */
    ANSWER(1, "来源回答"),
    /**
     * 来源活动
     */
    ACTIVITY(2, "来源活动"),
    /**
     * 来源活动
     */
    TOPIC(3, "来源话题"),
    /**
     * 来源活动
     */
    COMMENT(4, "来源评论"),
    ;

    /**
     * 根据type来获取枚举
     *
     * @param type 类型值
     * @return enums.SourceTypeEnum
     * @author Pan Juncai
     * @date 2019/7/17 16:11
     */
    public static SourceTypeEnum getEnumByType(int type) {
        for (SourceTypeEnum value : values()) {
            if (value.getType() == type) {
                return value;
            }
        }
        return NONE;
    }

    /**
     * 类型
     */
    private int type;
    /**
     * 说明
     */
    private String desc;

    SourceTypeEnum(int type, String desc) {
        this.type = type;
        this.desc = desc;
    }

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
