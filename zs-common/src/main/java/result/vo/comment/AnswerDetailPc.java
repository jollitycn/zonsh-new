package result.vo.comment;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author wangJin
 *
 * @date 2019年6月13日 上午10:06:49
 *
 */
@Data
public class AnswerDetailPc implements Serializable {

  private static final long serialVersionUID = 1L;
  private Long tid;
  private Long aid;
  private String answerNumber;
  private Integer status;
  private Integer answerCount;
  private Long time;
  private Integer commentCount;
  private Integer likeCount;
  private String answerTitle;
  private String answerContent;

  private Integer inviteCount;
  private String topicContent;
  private List<String> topicImgList;

  private Long uid;
  private String headUrl;
  private String uname;

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
