package result.vo.user;

/**
 * @author Pan Juncai
 * @version 1.0
 * @date 2019/7/9 16:24
 */
public class RecommendUserInfoResult {
    /**
     * 用户id
     */
    private Long uid;

    /**
     * 用户名（昵称）
     */
    private String uname;

    /**
     * 头像地址
     */
    private String headurl;

    /**
     * 性别：性别 1男 2女 0未知
     */
    private Integer gender;

    /**
     * 用户简介（签名）
     */
    private String userSignature;

    /**
     * 关注状态：0 未关注  1 已关注  2 互相关注
     */
    private Integer followStatus;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

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

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getUserSignature() {
        return userSignature;
    }

    public void setUserSignature(String userSignature) {
        this.userSignature = userSignature;
    }

    public Integer getFollowStatus() {
        return followStatus;
    }

    public void setFollowStatus(Integer followStatus) {
        this.followStatus = followStatus;
    }

    @Override
    public String toString() {
        return "RecommendUserInfoResult{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", headurl='" + headurl + '\'' +
                ", gender=" + gender +
                ", userSignature='" + userSignature + '\'' +
                ", followStatus=" + followStatus +
                '}';
    }
}
