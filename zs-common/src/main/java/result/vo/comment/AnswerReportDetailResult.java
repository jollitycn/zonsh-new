package result.vo.comment;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author 王进
 */
@Data
@ApiModel(value = "回答举报")
public class AnswerReportDetailResult implements Serializable {

    private Long tid;
    @ApiModelProperty(value = "回答id")
    private Long aid;
    @ApiModelProperty(value = "回答编号")
    private String answerNumber;
    @ApiModelProperty(value = "状态")
    private Integer status;
    @ApiModelProperty(value = "回答数")
    private Integer answerCount;
    @ApiModelProperty(value = "评论时间")
    private Long time;
    @ApiModelProperty(value = "评论数")
    private Integer commentCount;
    @ApiModelProperty(value = "点赞数")
    private Integer likeCount;
    @ApiModelProperty(value = "回答标题")
    private String answerTitle;
    @ApiModelProperty(value = "回答内容")
    private String answerContent;
    @ApiModelProperty(value = "邀请数")
    private Integer inviteCount;
    @ApiModelProperty(value = "话题内容")
    private String topicContent;
    @ApiModelProperty(value = "话题图片")
    private List<String> topicImgList;
    @ApiModelProperty(value = "用户id")
    private Long uid;
    @ApiModelProperty(value = "用户头像")
    private String headUrl;
    @ApiModelProperty(value = "用户昵称")
    private String uName;

    @ApiModelProperty(value = "回答举报id")
    private Long zrid;
    @ApiModelProperty(value = "回答举报举报类型")
    private String reportTitle;
    @ApiModelProperty(value = "举报内容")
    private String reportContent;
    @ApiModelProperty(value = "举报时间")
    private String reportTime;
    @ApiModelProperty(value = "举报用户")
    private String reportUname;
    @ApiModelProperty(value = "举报头像")
    private String reportHeadurl;
}
