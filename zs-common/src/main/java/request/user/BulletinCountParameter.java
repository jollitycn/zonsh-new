package request.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
@Data
@ApiModel("入参实体")
public class BulletinCountParameter implements Serializable {

    @ApiModelProperty(value = "公告bnid", name = "bnid", required = true, example = "10")
    @NotNull(message = "公告bnid不能为空")
    @Min(value = 1L, message = "bnid不合法")
    @Max(value = Long.MAX_VALUE, message = "bnid超过最大值")
    private Long  bnid;
}
