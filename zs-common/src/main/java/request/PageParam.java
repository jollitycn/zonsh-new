package request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * @author Pan Juncai
 * @version 1.0
 * @date 2019/7/12 16:57
 */
 @ApiModel("分页信息")
 @Data
public class PageParam {
    /**
     * 当前页
     */
    @ApiModelProperty(value = "当前页", name = "pageNum", required = true, example = "1")
    @Min(value=1L, message="查询页码最小为1")
    @Max(value=2147483647L, message="查询页码超出最大限制")
    protected Integer pageNum;

    /**
     * 每页大小
     */
    @ApiModelProperty(value = "每页大小", name = "pageSize", required = true, example = "10")
    @Min(value=1L, message="每页最少查询一条数据")
    @Max(value=100L, message="查询数量超出限制")
    protected Integer pageSize;
}
