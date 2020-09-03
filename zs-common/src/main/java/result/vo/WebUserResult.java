package result.vo;

import java.io.Serializable;
import lombok.Data;

/**
 * @author wangJin
 *
 * @date 2019年6月11日 下午6:03:24
 *
 */
@Data
public class WebUserResult implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * 用户主键ID
   */
  private Long uid;
  private String number;
  // 用户手机号
  private String phone;
  // 用户名称
  private String uname;
  // 头像
  private String headurl;
  // 0 新用户
  private Integer status;
  // 创建时间
  private String createTime;
  // 关注数
  private Integer attentionCount;

}
