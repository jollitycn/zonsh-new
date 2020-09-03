package request.comment;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class QueryCommentReportParameter {

  /**
   * 开始时间
   */
  @ApiModelProperty(value = "开始时间", name = "startTime", required = false)
  private String startTime;
  /**
   * 结束时间
   */
  @ApiModelProperty(value = "结束时间", name = "endTime", required = false)
  private String endTime;
  /**
   * 评论的类型：1---回答  2---活动
   */
  @ApiModelProperty(value = "评论的类型：1---回答  2---活动，可多选", name = "commentTypeList")
  private String commentType;
  /**
   * 搜索框：评论人、评论内容
   */
  @ApiModelProperty(value = "搜索框：评论人、评论内容", name = "searchKey")
  private String searchKey;
  /**
   * 当前页
   */
  @ApiModelProperty(value = "当前页", name = "pageNum", required = true, example = "1")
  @NotNull(message = "pageNum不能为空")
  @Min(value = 1, message = "当前页数不合法")
  @Max(value = Integer.MAX_VALUE, message = "当前页数不合法")
  private Integer pageNum;
  /**
   * 每页大小
   */
  @ApiModelProperty(value = "每页大小", name = "pageSize", required = true, example = "10")
  @NotNull(message = "pageSize不能为空")
  @Min(value = 1, message = "每页大小不合法")
  @Max(value = Integer.MAX_VALUE, message = "每页大小不合法")
  private Integer pageSize;
}
