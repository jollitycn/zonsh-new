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
 * @date 2019/6/27 11:23
 */
@ApiModel(value = "创建banner请求参数对象", description = "创建bannner请求参数对象")
public class BannerParameter implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 类型：0---线上
     */
    @ApiModelProperty(value = "类型：0---线上", name = "bannerType", required = true, example = "0")
    @NotNull(message = "bannerType不能为空：0---线上")
    @Min(value = 0, message = "类型：0---线上")
    private Integer bannerType;
    /**
     * 活动id
     */
    @ApiModelProperty(value = "活动id", name = "aid", required = true, example = "100")
    @NotNull(message = "活动id不能为空")
    @Min(value = 1L, message = "aid最小为1")
    @Max(value = Long.MAX_VALUE, message = "aid超过最大值")
    private Long aid;
    /**
     * 封面图片地址
     */
    @ApiModelProperty(value = "封面图片地址", name = "coverUrl", required = true)
    @NotBlank(message = "封面地址不能为空")
    private String coverUrl;

    public Integer getBannerType() {
        return bannerType;
    }

    public void setBannerType(Integer bannerType) {
        this.bannerType = bannerType;
    }

    public Long getAid() {
        return aid;
    }

    public void setAid(Long aid) {
        this.aid = aid;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    @Override
    public String toString() {
        return "BannerParameter{" +
                "bannerType=" + bannerType +
                ", aid=" + aid +
                ", coverUrl='" + coverUrl + '\'' +
                '}';
    }
}
