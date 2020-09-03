package social.entity;

import com.baomidou.mybatisplus.enums.IdType;

import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * <p>
 * 回答举报表
 * </p>
 *
 * @author wangJin
 * @since 2019-07-22
 */
@TableName("zs_report")
public class Report extends Model<Report> {

    private static final long serialVersionUID = 1L;

    /**
     * 回答举报表id
     */
    @TableId(value = "arid", type = IdType.AUTO)
    private Long arid;

    /**
     * 回答表id
     */
    private Long id;

    /**
     * 举报人用户id
     */
    private Long uid;

    /**
     * 举报标题
     */
    @TableField("report_title")
    private String reportTitle;
    /**
     * 举报内容
     */
    @TableField("report_content")
    private String reportContent;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 类型（0：回答，1：评论）
     */
    private Integer type;

    /**
     * 操作人id
     */
    private Long operateId;

    /**
     * 操作时间
     */
    private Date operateTime;

    @Override
    protected Serializable pkVal() {
        return this.arid;
    }

    public Long getArid() {
        return arid;
    }

    public void setArid(Long arid) {
        this.arid = arid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getReportContent() {
        return reportContent;
    }

    public void setReportContent(String reportContent) {
        this.reportContent = reportContent;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getOperateId() {
        return operateId;
    }

    public void setOperateId(Long operateId) {
        this.operateId = operateId;
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    public String getReportTitle() {
        return reportTitle;
    }

    public void setReportTitle(String reportTitle) {
        this.reportTitle = reportTitle;
    }
}
