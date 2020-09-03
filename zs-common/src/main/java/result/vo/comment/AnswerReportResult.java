package result.vo.comment;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class AnswerReportResult implements Serializable {
    private Long arid;
    private Long tid;
    private Long  id;
    private Long uid;
    private String reportTitle;
    private Integer type;
    private String answerTitle;// 回答概述
    private String answerContent;// 回答内容
    private String topic;// 来源（话题内容）
    private String uName;// 用户名称
    private Date publishTime;// 发布时间
    private String reportContent;
    private Integer readCount;// 阅读数
    private Integer commentCount;// 评论数
    private Integer likeCount;// 点赞数

    private  Date reportTime;
    private String reportUName;
}
