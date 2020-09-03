package request.activity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * @author Pan Juncai
 * @version 1.0
 * @date 2019/6/27 14:56
 */
@ApiModel(value = "活动分页列表查询条件", description = "活动分页列表查询条件")
public class QueryActivityPageParameter {
    /**
     * 状态---1：未发布（草稿、已下架），2：已发布（进行中、已上架）
     */
    @ApiModelProperty(value = "状态：1---未发布 2---已发布", name = "status", required = true, example = "1")
    @NotNull(message = "status不能为空：1---未发布 2---已发布")
    @Min(value = 1, message = "status只能是：1---未发布 2---已发布")
    @Max(value = 2, message = "status只能是：1---未发布 2---已发布")
    private Integer status;
    /**
     * 开始时间
     */
    @ApiModelProperty(value = "开始时间", name = "startTime", required = false)
    private Date startTime;
    /**
     * 结束时间
     */
    @ApiModelProperty(value = "结束时间", name = "endTime", required = false)
    private Date endTime;
    /**
     * 活动类型(多选)：0---线上  1---线下
     */
    @ApiModelProperty(value = "活动类型", name = "activityTypeList", required = false)
    private List<Integer> activityTypeList;
    /**
     * 搜索活动ID、名称
     */
    @ApiModelProperty(value = "输入框：活动ID、名称", name = "searchKey", required = false)
    private String searchKey;
    /**
     * 当前页
     */
    @ApiModelProperty(value = "当前页", name = "pageNum", required = true, example = "1")
    @NotNull(message = "pageNum不能为空")
    @Min(value = 1, message = "当前页数不合法")
    @Max(value = Integer.MAX_VALUE, message = "当前页数不合法")
    private Integer pageNum;
    /**
     * 每页大小
     */
    @ApiModelProperty(value = "每页大小", name = "pageSize", required = true, example = "10")
    @NotNull(message = "pageSize不能为空")
    @Min(value = 1, message = "每页大小不合法")
    @Max(value = Integer.MAX_VALUE, message = "每页大小不合法")
    private Integer pageSize;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public List<Integer> getActivityTypeList() {
        return activityTypeList;
    }

    public void setActivityTypeList(List<Integer> activityTypeList) {
        this.activityTypeList = activityTypeList;
    }

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "QueryActivityPageParameter{" +
                "status=" + status +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", activityTypeList=" + activityTypeList +
                ", searchKey='" + searchKey + '\'' +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                '}';
    }
}
