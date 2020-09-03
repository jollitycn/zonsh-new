package request.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import request.PageParam;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author Pan Juncai
 * @version 1.0
 * @date 2019/7/26 11:23
 */
@ApiModel("入参实体")
@Data
public class UidPageParameter extends PageParam {
    /**
     * 用户uid
     */
    @ApiModelProperty(value = "用户uid", name = "uid", required = true, example = "10")
    @NotNull(message = "用户uid不能为空")
    @Min(value = 1L, message = "uid不合法")
    @Max(value = Long.MAX_VALUE, message = "uid超过最大值")
    private Long uid;
}
