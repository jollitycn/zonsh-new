package result.vo.comment;

import lombok.Data;

import java.util.Date;

/**
 * @author 王进
 */
@Data
public class CommentReportResult {

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
    private Date reportTime;
    /**
     * 举报用户
     */
    private String reportUName;
}
