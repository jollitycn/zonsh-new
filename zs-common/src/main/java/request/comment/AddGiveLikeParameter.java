package request.comment;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 新增点赞入参实体
 *
 * @author Pan Juncai
 * @version 1.0
 * @date 2019/7/24 15:56
 */
@Data
@ApiModel("新增点赞入参实体")
public class AddGiveLikeParameter implements Serializable {
    /**
     * 点赞类型： 1---回答  2---活动  3---话题   4---评论
     */
    @ApiModelProperty(value = "点赞类型： 1---回答  2---活动  3---话题   4---评论", name = "likeType", required = true, example =
            "1")
    @NotNull(message = "likeType不能为空")
    @Min(value = 1, message = "点赞类型： 1---回答  2---活动  3---话题   4---评论")
    @Max(value = 4, message = "点赞类型： 1---回答  2---活动  3---话题   4---评论")
    private Integer likeType;

    /**
     * 点赞对象的主键id
     */
    @ApiModelProperty(value = "点赞对象的主键id", name = "dataId", required = true, example = "100")
    @NotNull(message = "点赞对象的主键id不能为空")
    @Min(value = 1L, message = "dataId最小为1")
    @Max(value = Long.MAX_VALUE, message = "dataId超过最大值")
    private Long dataId;
}
