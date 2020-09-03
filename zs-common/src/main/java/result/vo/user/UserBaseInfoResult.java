package result.vo.user;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户基本信息（包含统计）
 *
 * @author Pan Juncai
 * @version 1.0
 * @date 2019/7/26 10:21
 */
@Data
public class UserBaseInfoResult implements Serializable {
    /**
     * 用户uid
     */
    private Long uid;
    /**
     * 用户头像地址
     */
    private String headUrl;
    /**
     * 个人简介
     */
    private String userSignature;
    /**
     * 用户名称（昵称）
     */
    private String uname;
    /**
     * 性别 1男 2女 0未知
     */
    private Integer gender;
    /**
     * 关注数
     */
    private Long followCount;
    /**
     * 粉丝数
     */
    private Long fansCount;
    /**
     * 赞同数（回答总赞数）
     */
    private Long likeCount;
    /**
     * 关注状态：0 未关注  1 已关注  2 互相关注
     */
    private Integer followStatus;
}
