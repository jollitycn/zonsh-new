package request.activity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author Pan Juncai
 * @version 1.0
 * @date 2019/6/26 15:47
 */
@ApiModel(value = "修改活动请求参数对象", description = "修改活动请求参数对象")
public class UpdateActivityParameter implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 活动id
     */
    @ApiModelProperty(value = "活动id", name = "aid", required = true, example = "100")
    @NotNull(message = "活动id不能为空")
    @Min(value = 1L, message = "aid最小为1")
    @Max(value = Long.MAX_VALUE, message = "aid超过最大值")
    private Long aid;
    /**
     * 活动标题（主题）
     */
    @ApiModelProperty(value = "活动名称", name = "activityTitle", required = true, example = "爬山活动")
    @NotBlank(message = "活动名称不能为空")
    private String activityTitle;
    /**
     * 活动内容（说明）
     */
    @ApiModelProperty(value = "活动说明", name = "activityContent", required = true, example = "去爬梧桐山")
    @NotBlank(message = "活动说明不能为空")
    private String activityContent;
    /**
     * 状态---1：未发布（草稿、已下架），2：已发布（进行中、已上架）
     */
    @ApiModelProperty(value = "状态：1---未发布 2---已发布", name = "status", required = true, example = "1")
    @NotNull(message = "status不能为空：1---未发布 2---已发布")
    @Min(value = 1, message = "status只能是：1---未发布 2---已发布")
    @Max(value = 2, message = "status只能是：1---未发布 2---已发布")
    private Integer status;

    public Long getAid() {
        return aid;
    }

    public void setAid(Long aid) {
        this.aid = aid;
    }

    public String getActivityTitle() {
        return activityTitle;
    }

    public void setActivityTitle(String activityTitle) {
        this.activityTitle = activityTitle;
    }

    public String getActivityContent() {
        return activityContent;
    }

    public void setActivityContent(String activityContent) {
        this.activityContent = activityContent;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UpdateActivityParameter{" +
                "aid=" + aid +
                ", activityTitle='" + activityTitle + '\'' +
                ", activityContent='" + activityContent + '\'' +
                ", status=" + status +
                '}';
    }
}
