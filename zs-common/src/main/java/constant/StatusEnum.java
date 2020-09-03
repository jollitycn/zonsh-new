package constant;

/**
 * @author Xc
 * @version 1.0
 * @Date 2018/12/3
 */
public enum  StatusEnum {
	
	//基础错误
    STATUS_SUCCESS(200,"SUCCESS"),
    STATUS_NOLOGIN(201,"未登陆"),
    STATUS_INVALIDTOKEN(202,"token异常"),
    PASSWORD_WRONG(203,"密码错误"),
    INNER_ERROR(204,"方法内部执行错误"),
    NO_BEANS(205,"目标业务模块不存在"),
    NO_METHOD(206,"目标方法不存在"),
    PARAMS_FILE(207,"参数校验失败"),
    NO_CHANNEL(208,"非法的请求渠道"),
    OTHER_ERROR(500,"服务器异常"),

    

    //token校验类错误
    JWT_ERRCODE_NULL(2021,"token不存在"),
    JWT_ERRCODE_EXPIRE(2022,"token过期"),
    JWT_ERRCODE_FAIL(2023,"token验证失败"),

    //业务类错误
    PARAMNULL_ERROR(300,"参数不能为空"),
    USERNAME_ERROR(310,"昵称已存在"),
    USERPHONE_ERROR(311,"手机号已存在"),
    USERNULL_ERROR(312,"用户不存在"),
    CODE_ERROR(313,"验证码错误"),
    SENDCODE_ERROR(314,"验证码发送失败"),
	FOLLOW_ERROR(315,"不能关注自己");
	
    private int code;
    private String desc;

    private StatusEnum(int code,String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return this.code;
    }

    public String getDesc() {
        return this.desc;
    }

    public static String getDesc(int code) {
        for (StatusEnum statusEnum : StatusEnum.values()) {
            if (statusEnum.getCode() == code) {
                return  statusEnum.desc;
            }
        }

        return null;
    }
}
