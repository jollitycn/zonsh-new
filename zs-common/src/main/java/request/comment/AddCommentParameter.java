package request.comment;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Pan Juncai
 * @version 1.0
 * @date 2019/7/1 17:53
 */
@ApiModel(value = "新增评论实体对象", description = "新增评论实体对象")
public class AddCommentParameter {
    /**
     * 回答/活动id
     */
    @ApiModelProperty(value = "回答/活动id", name = "aid", required = true, example = "100")
    @NotNull(message = "回答/活动id不能为空")
    @Min(value = 1L, message = "aid最小为1")
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
     * 评论内容
     */
    @ApiModelProperty(value = "评论内容", name = "commentContent", required = true, example = "美女帅哥程序猿")
    @NotBlank(message = "评论内容不能为空")
    private String commentContent;

    public Long getAid() {
        return aid;
    }

    public void setAid(Long aid) {
        this.aid = aid;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Integer getCommentType() {
        return commentType;
    }

    public void setCommentType(Integer commentType) {
        this.commentType = commentType;
    }

    @Override
    public String toString() {
        return "AddCommentParameter{" +
                "aid=" + aid +
                ", commentType=" + commentType +
                ", commentContent='" + commentContent + '\'' +
                '}';
    }
}
