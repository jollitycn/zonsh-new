package result.vo.comment;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Pan Juncai
 * @version 1.0
 * @date 2019/7/25 16:44
 */
@Data
public class MyLikeResult implements Serializable {
    /**
     * 点赞主键id
     */
    private Long lid;
    /**
     * 点赞人uid
     */
    private Long uid;
    /**
     * 点赞人名称
     */
    private String uname;
    /**
     * 点赞人头像
     */
    private String headUrl;
    /**
     * 点赞类型： 1---回答  2---活动  3---话题   4---评论
     */
    private Integer likeType;
    /**
     * 点赞对象的主键id
     */
    private Long dataId;
    /**
     * 该 回答或者评论上上级 的话题tid
     */
    private Long tid;
    /**
     * 该回答或者评论回答 的回答aid
     */
    private Long aid;
    /**
     * 点赞内容
     */
    private String content;
    /**
     * 点赞时间
     */
    private Long createTime;
}
