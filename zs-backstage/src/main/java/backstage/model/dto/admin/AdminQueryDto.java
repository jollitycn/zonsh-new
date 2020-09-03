package backstage.model.dto.admin;

import com.baomidou.mybatisplus.annotations.TableField;
import dto.BaseDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author liqun
 * @version 1.0
 * @date 2019/7/9 19:01
 * @description The class Admin query dto
 */
@Data
@ApiModel(value = "管理员分页查询dto")
@EqualsAndHashCode(callSuper = true)
public class AdminQueryDto extends BaseDto {

    /**
     * 页面索引
     */
    @ApiModelProperty(value = "页面索引",example = "1")
    private int pageNum;

    /**
     * 页面记录数
     */
    @ApiModelProperty(value = "页面记录数",example = "10")
    private int pageSize;

    /**
     * 用户昵称
     */
//    @ApiModelProperty(value = "用户昵称")
//    private String nickName;

    /**
     * 用户手机号
     */
//    @ApiModelProperty(value = "用户手机号")
//    private String phone;
    /**
     * 搜索条件
     */
    @ApiModelProperty(value = "搜索条件")
    private String searchContent;

    /**
     * 状态(0:正常 1:冻结)
     */
    @ApiModelProperty(value = "状态",example = "(0:正常 1:冻结)")
    private String status;
}
