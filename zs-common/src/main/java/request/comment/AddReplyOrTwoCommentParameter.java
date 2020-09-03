package request.comment;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Pan Juncai
 * @version 1.0
 * @date 2019/7/11 13:55
 */
@ApiModel("添加二级评论或者回复入参数实体")
@Data
public class AddReplyOrTwoCommentParameter {

    /**
     * 上级评论的cid
     */
    @ApiModelProperty(value = "上级评论的cid", name = "parentCid", required = true, example = "10")
    @NotNull(message = "上级评论的cid不能为空")
    @Min(value = 1L, message = "parentCid最小为1")
    @Max(value = Long.MAX_VALUE, message = "parentCid超过最大值")
    private Long parentCid;

    /**
     * 评论内容
     */
    @ApiModelProperty(value = "评论内容", name = "commentContent", required = true, example = "美女帅哥程序猿")
    @NotBlank(message = "评论内容不能为空")
    private String commentContent;

    /**
     * 数据类型：1---一级评论  2---二级评论  3---二级评论的回复
     */
    @ApiModelProperty(value = "类型: 2---二级评论  3---二级评论的回复", name = "dataType", required = true, example = "2")
    @NotNull(message = "dataType不能为空")
    @Min(value = 2, message = "dataType最小为2")
    @Max(value = 3, message = "dataType最大值为3")
    private Integer dataType;
}
