package request.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author Pan Juncai
 * @version 1.0
 * @date 2019/7/8 16:52
 */
@ApiModel("修改个人信息入参实体")
public class UserBaseInfoParameter {

    /**
     * 用户名称
     */
    @ApiModelProperty(value = "昵称", name = "uname", example = "重拾一号")
    private String uname;

    /**
     * 头像地址
     */
    @ApiModelProperty(value = "头像地址", name = "headurl", example = "http://www.baidu.com")
    private String headurl;

    /**
     * 个人介绍（个人说明、签名）
     */
    @ApiModelProperty(value = "个人介绍（个人说明、签名）", name = "userSignature", example = "怀抱琼楼，心似世界！")
    private String userSignature;

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getHeadurl() {
        return headurl;
    }

    public void setHeadurl(String headurl) {
        this.headurl = headurl;
    }

    public String getUserSignature() {
        return userSignature;
    }

    public void setUserSignature(String userSignature) {
        this.userSignature = userSignature;
    }

    @Override
    public String toString() {
        return "UserBaseInfoParameter{" +
                "uname='" + uname + '\'' +
                ", headurl='" + headurl + '\'' +
                ", userSignature='" + userSignature + '\'' +
                '}';
    }
}
