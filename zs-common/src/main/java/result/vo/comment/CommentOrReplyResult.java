package result.vo.comment;

import lombok.Data;

import java.util.Date;

/**
 * @author Pan Juncai
 * @version 1.0
 * @date 2019/7/3 11:25
 */
 @Data
public class CommentOrReplyResult {
    /**
     * id
     */
    private Long cid;
    /**
     * 回答/活动id
     */
    private Long aid;
    /**
     * 评论内容
     */
    private String commentContent;
    /**
     * 评论的类型：1---回答  2---活动
     */
    private Integer commentType;
    /**
     * 评论类型的内容
     */
    private String commentTypeContent;
    /**
     * 评论人名称
     */
    private String commentUname;
    /**
     * 创建时间（评论时间）
     */
    private Date createTime;

    /**
     * 举报id
     */
    private Long arid;
    /**
     * 举报原因
     */
    private String reportTitle;
    /**
     * 举报时间
     */
    private String reportTime;
    /**
     * 举报用户
     */
    private String reportUName;
}
