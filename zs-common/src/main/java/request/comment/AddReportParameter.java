package request.comment;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 新增举报入参实体
 *
 * @author Pan Juncai
 * @version 1.0
 * @date 2019/7/24 10:51
 */
@Data
@ApiModel("新增举报入参实体")
public class AddReportParameter implements Serializable {
    /**
     * 回答的aid/评论的cid
     */
    @ApiModelProperty(value = "回答的aid/评论的cid", name = "id", required = true, example = "100")
    @NotNull(message = "回答的aid/评论的cid不能为空")
    @Min(value = 1L, message = "id最小为1")
    @Max(value = Long.MAX_VALUE, message = "id超过最大值")
    private Long id;
    /**
     * 举报标题
     */
    @ApiModelProperty(value = "举报标题", name = "reportTitle", required = true, example = "恶意攻击")
    @NotBlank(message = "举报标题不能为空")
    private String reportTitle;
    /**
     * 举报内容
     */
    @ApiModelProperty(value = "举报内容，非必填", name = "reportContent", example = "哈哈，我逗你的呢")
    private String reportContent;
    /**
     * 类型（1：回答，4：评论）
     */
    @ApiModelProperty(value = "举报类型：1---回答  4---评论", name = "type", required = true, example = "1")
    @NotNull(message = "type不能为空")
    @Min(value = 1, message = "类型（1：回答，4：评论）")
    @Max(value = 4, message = "类型（1：回答，4：评论）")
    private Integer type;
}
