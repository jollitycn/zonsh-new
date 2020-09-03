package result;

public class ResultConstans {
    public static final String SUCCESS_MSG = "操作成功";
    public static final String SUCCESS_CODE = "200";

    public static final String ERROR_MSG = "操作失败";
    public static final String ERROR_CODE = "201";

    public static final String ERROR_DEVICE_NULL_MSG = "操作失败，设备标识不存在";
    public static final String ERROR_DEVICE_NULL_CODE = "202";

    public static final String ERROR_USER_NULL_MSG = "操作失败，该用户不存在";
    public static final String ERROR_USER_NULL_CODE = "203";

    public static final String ERROR_USER_ERROR_MSG = "登录失败，该用户已经被冻结";
    public static final String ERROR_USER_ERROR_CODE = "204";

    public static final String ERROR_POWER_MSG = "操作失败，没有此权限,请联系管理员";
    public static final String ERROR_POWER_CODE = "205";

    public static final String ERROR_ISUSER_MSG = "操作失败，不能添加自己";
    public static final String ERROR_ISUSER_CODE = "206";

    public static final String ERROR_USER_PWD_MSG = "密码错误，请重新输入";
    public static final String ERROR_USER_PWD_CODE = "207";

    public static final String ERROR_PHONE_MSG = "手机号不能为空或手机号格式不正确";
    public static final String ERROR_PHONE_CODE = "208";

    public static final String ERROR_CODE_MSG = "验证码错误";
    public static final String ERROR_CODE_CODE = "209";

    public static final String ERROR_LOGIN_MSG = "请勿重复登录";
    public static final String ERROR_LOGIN_CODE = "210";

    public static final String ERROR_REGISTER_MSG = "该号码已被注册";
    public static final String ERROR_REGISTER_CODE = "211";

    public static final String ERROR_VALIDATION_MSG = "短信发送失败";
    public static final String ERROR_VALIDATION_CODE = "212";

    public static final String ERROR_EXECL_MSG = "上传EXECL格式不正确";
    public static final String ERROR_EXECL_CODE = "213";

    public static final String ERROR_FILE_MSG = "文件路径错误";
    public static final String ERROR_FILE_CODE = "214";
    
    public static final String CODE_ERROR_MSG = "验证码无效";
    public static final String CODE_ERROR_CODE = "215";
    
    public static final String USER_BIND_ERROR_MSG = "绑定手机失败，该手机号已经绑定微信账号";
    public static final String USER_BIND_ERROR_CODE = "216";
    
    public static final String USER_WXBIND_MSG = "该手机号已经注册，是否绑定微信";
    public static final String USER_WXBIND_CODE = "217";
    
    public static final String USER_WXBIND_ERROR_MSG = "该手机号已经注册且已经绑定微信，请更换手机号";
    public static final String USER_WXBIND_ERROR_CODE = "218";
    
    public static final String TOKEN_NULL_ERROR_MSG = "TOKEN为空";
    public static final String TOKEN_NULL_ERROR_CODE = "219";
    
    public static final String TOKEN_ERROR_MSG = "TOKEN无效";
    public static final String TOKEN_ERROR_CODE = "220";
    
    public static final String ANSWER_ERROR_MSG = "该回答已被屏蔽";
    public static final String ANSWER_ERROR_CODE = "221";
    
    public static final String ANSWER_NULL_MSG = "该问题没有回答或已被删除";
    public static final String ANSWER_NULL_CODE = "222";
    
    public static final String INVITATION_ERROR_MSG = "不允许邀请自己";
    public static final String INVITATION_ERROR_CODE = "223";

    public static final String CONTENT_ILLEGAL_MSG = "填写内容非法，禁止操作！";
    public static final String CONTENT_ILLEGAL_CODE = "224";

    public static final String USER_LIKE_EXIST_MSG = "已点赞，请勿重复点赞！";
    public static final String USER_LIKE_EXIST_CODE = "225";

    public static final String USER_LIKE_NOT_EXIST_MSG = "还未点赞，请刷新后再尝试！";
    public static final String USER_LIKE_NOT_EXIST_CODE = "226";

    public static final String USER_COLLECTION_EXIST_MSG = "已收藏，请勿重复收藏！";
    public static final String USER_COLLECTION_EXIST_CODE = "227";

    public static final String USER_COLLECTION_NOT_EXIST_MSG = "还未收藏，请请刷新后再尝试！";
    public static final String USER_COLLECTION_NOT_EXIST_CODE = "228";

    public static final String USER_NOT_EXIST_MSG = "该用户不存在，或已冻结！";
    public static final String USER_NOT_EXIST_CODE = "229";
    
}
