package request.comment;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author Pan Juncai
 * @version 1.0
 * @date 2019/7/2 17:48
 */
@ApiModel("获取评论分页列表")
public class GetCommentPageParameter {
    /**
     * 回答/活动id
     */
    @ApiModelProperty(value = "回答/活动id", name = "aid", required = true, example = "100")
    @NotNull(message = "回答/活动id不能为空")
    @Max(value = Long.MAX_VALUE, message = "aid超过最大值")
    private Long aid;
    /**
     * 评论的类型：1---回答  2---活动
     */
    @ApiModelProperty(value = "评论的类型：1---回答  2---活动", name = "commentType", required = true, example = "1")
    @NotNull(message = "commentType不能为空")
    @Min(value = 1L, message = "commentType最小为1")
    @Max(value = Long.MAX_VALUE, message = "commentType超过最大值")
    private Integer commentType;
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

    public Long getAid() {
        return aid;
    }

    public void setAid(Long aid) {
        this.aid = aid;
    }

    public Integer getCommentType() {
        return commentType;
    }

    public void setCommentType(Integer commentType) {
        this.commentType = commentType;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "GetCommentPageParameter{" +
                "aid=" + aid +
                ", commentType=" + commentType +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                '}';
    }
}
