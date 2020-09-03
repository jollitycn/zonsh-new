package enums;

/**
 * @author liqun
 * @version 1.0
 * @date 2019/7/9 10:45
 * @description The class Error code enum.
 */
public enum ErrorCodeEnum {
    /**
     * Gl 99990100 error code enum.
     */
    GL99990100(9999100, "参数异常"),
    /**
     * Gl 99990401 error code enum.
     */
    GL99990401(99990401, "无访问权限"),
    /**
     * Gl 000500 error code enum.
     */
    GL99990500(500, "未知异常"),
    /**
     * Gl 000403 error code enum.
     */
    GL99990403(9999403, "无权访问"),
    /**
     * Gl 000404 error code enum.
     */
    GL9999404(9999404, "找不到指定资源"),
    /**
     * Gl 99990001 error code enum.
     */
    GL99990001(99990001, "注解使用错误"),
    /**
     * Gl 99990002 error code enum.
     */
    GL99990002(99990002, "微服务不在线,或者网络超时"),

    GL99990003(99990003, "参数不能为空"),

//  1001 用户中心
    AUTH10010001(10010001, "会话超时,请刷新页面重试"),

    AUTH10010002(10010002, "新增后台管理员失败"),

    AUTH10010003(10010003, "冻结账号失败"),

    AUTH10010004(10010004, "恢复账号失败"),

    AUTH10010005(10010005, "设置操作权限失败"),

    AUTH10010006(10010006, "用户和账号或密码不能为空"),

    AUTH10010007(10010007, "用户账号不存在"),

    AUTH10010008(10010008, "用户账号已冻结,无法登录系统"),

    AUTH10010009(10010009, "页面已过期,请重新登录"),

    AUTH100100010(100100010, "操作越权"),

    AUTH100100011(100100011, "操作非法"),

    AUTH100100012(100100012, "验证token失败"),

    AUTH100100013(100100013, "解析header失败"),

    AUTH100100014(100100014, "用无会话信息,请登录"),

    AUTH100100015(100100015, "用户密码错误"),

    AUTH100100016(100100016, "手机号码重复"),

    AUTH100100017(100100017, "该昵称已存在"),
    ;
    private int code;
    private String msg;

    /**
     * Msg string.
     *
     * @return the string
     */
    public String msg() {
        return msg;
    }

    /**
     * Code int.
     *
     * @return the int
     */
    public int code() {
        return code;
    }

    ErrorCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * Gets enum.
     *
     * @param code the code
     *
     * @return the enum
     */
    public static ErrorCodeEnum getEnum(int code) {
        for (ErrorCodeEnum ele : ErrorCodeEnum.values()) {
            if (ele.code() == code) {
                return ele;
            }
        }
        return null;
    }
}
