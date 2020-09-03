package enums;

/**
 * 消息类型的枚举
 *
 * @author Pan Juncai
 * @version 1.0
 * @date 2019/7/29 13:27
 */
public enum MessageTypeEnum {
    /**
     * 无
     */
    NONE(0, "无"),
    /**
     * 小助手
     */
    HELPER(1, "小助手"),
    /**
     *
     */
    INVITATION(2, "回答邀请"),
    /**
     * 互动
     */
    INTERACTIVE(3, "互动"),
    /**
     * 关注
     */
    FOLLOW(4, "关注"),
    /**
     *
     */
    FEEDBACK(5, "反馈"),
    ;

    /**
     * 根据type来获取枚举
     *
     * @param type 类型值
     * @return enums.MessageTypeEnum
     * @author Pan Juncai
     * @date 2019/7/29 13:11
     */
    public static MessageTypeEnum getEnumByType(int type) {
        for (MessageTypeEnum value : values()) {
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

    MessageTypeEnum(int type, String desc) {
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
