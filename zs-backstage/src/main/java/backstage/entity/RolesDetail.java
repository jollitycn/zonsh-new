package backstage.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author xc
 * @since 2019-07-12
 */
@TableName("zs_roles_detail")
public class RolesDetail extends Model<RolesDetail> {

    private static final long serialVersionUID = 1L;

    /**
     * 角色详情表主键id
     */
    private Long rdid;

    /**
     * 角色id
     */
    private Long rid;
    
    /**
     * 1一级菜单 2二级菜单
     */
    @TableField("rd_type")
    private Integer rdType;

    /**
     * 二级菜单id  
     */
    private Long mid;

    /**
     * 读 0选中 1未选中
     */
    private Integer read;

    /**
     * 读 0选中 1未选中
     */
    private Integer write;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    public Long getRdid() {
        return rdid;
    }

    public void setRdid(Long rdid) {
        this.rdid = rdid;
    }
    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }
    public Long getMid() {
        return mid;
    }

    public void setMid(Long mid) {
        this.mid = mid;
    }
    public Integer getRead() {
        return read;
    }

    public void setRead(Integer read) {
        this.read = read;
    }
    public Integer getWrite() {
        return write;
    }

    public void setWrite(Integer write) {
        this.write = write;
    }
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    

    public Integer getRdType() {
		return rdType;
	}

	public void setRdType(Integer rdType) {
		this.rdType = rdType;
	}

	@Override
    protected Serializable pkVal() {
        return this.rdid;
    }

    
    
    @Override
    public String toString() {
        return "RolesDetail{" +
        "rdid=" + rdid +
        ", rid=" + rid +
        ", mid=" + mid +
        ", read=" + read +
        ", write=" + write +
        ", createTime=" + createTime +
        "}";
    }
}
