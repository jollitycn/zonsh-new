package enums;

/**
 * 0---线上  1---线下
 *
 * @author Pan Juncai
 * @version 1.0
 * @date 2019/7/18 16:37
 */
public enum ActivityTypeEnum {
    /**
     * 线上
     */
    ONLINE(0, "线上"),
    /**
     *
     */
    OFFLINE(1, "线下"),
    ;
    /**
     * 类型
     */
    private int type;
    /**
     * 说明
     */
    private String desc;

    ActivityTypeEnum(int type, String desc) {
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
