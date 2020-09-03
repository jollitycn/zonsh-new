package request.comment;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * @author Pan Juncai
 * @version 1.0
 * @date 2019/7/3 10:54
 */
@ApiModel("分页查询所有评论列表入参实体")
@Data
public class QueryCommentPageParameter {

    /**
     * 状态：0---已删除  1---使用中  2---屏蔽
     */
    @ApiModelProperty(value = "状态：1---正常  2---屏蔽", name = "status", required = true, example = "1")
    @NotNull(message = "status不能为空")
    @Min(value = 1, message = "status最小为1")
    @Max(value = 2, message = "status超过最大值")
    private Integer status;
    /**
     * 开始时间
     */
    @ApiModelProperty(value = "开始时间", name = "startTime", required = false)
    private Date startTime;
    /**
     * 结束时间
     */
    @ApiModelProperty(value = "结束时间", name = "endTime", required = false)
    private Date endTime;
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
