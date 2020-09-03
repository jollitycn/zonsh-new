package request.comment;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 新增收藏入参实体
 *
 * @author Pan Juncai
 * @version 1.0
 * @date 2019/7/24 15:56
 */
@Data
@ApiModel("新增收藏入参实体")
public class AddCollectionParameter implements Serializable {
    /**
     * 收藏类型： 1---回答  3---话题   4---评论
     */
    @ApiModelProperty(value = "收藏类型： 1---回答  3---话题   4---评论", name = "collectionType", required = true, example =
            "1")
    @NotNull(message = "collectionType不能为空")
    @Min(value = 1, message = "收藏类型： 1---回答  3---话题   4---评论")
    @Max(value = 4, message = "收藏类型： 1---回答  3---话题   4---评论")
    private Integer collectionType;

    /**
     * 收藏的数据的主键id
     */
    @ApiModelProperty(value = "收藏的数据的主键id", name = "dataId", required = true, example = "100")
    @NotNull(message = "收藏的数据的主键id不能为空")
    @Min(value = 1L, message = "dataId最小为1")
    @Max(value = Long.MAX_VALUE, message = "dataId超过最大值")
    private Long dataId;
}
