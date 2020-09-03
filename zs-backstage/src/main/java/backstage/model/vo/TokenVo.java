package backstage.model.vo;

import base.BaseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author liqun
 * @version 1.0
 * @date 2019/7/12 15:42
 * @description 会话vo
 */
@Data
@ApiModel(value = "会话vo")
@EqualsAndHashCode(callSuper = true)
public class TokenVo extends BaseVO {

    /**
     * 用户账号
     */
    @ApiModelProperty(value = "用户账号")
    private String loginAccount;;

    /**
     * 唯一会话id
     */
    @ApiModelProperty(value = "唯一会话id")
    private String sessionId;
}
