package request;

import java.io.Serializable;
import java.util.List;
import javax.validation.constraints.NotBlank;
import lombok.Data;

/**
 * @author wangJin
 *
 * @date 2019年5月29日 上午10:51:46
 *
 */
@Data
public class TopicParameter implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long tid;//
  private Long uid;
  private Long uaid;//话题创建人id
  private String topicTitle;// 话题标题
  @NotBlank(message = "话题内容不能为空")
  private String topicContent;// 话题内容
  private Integer status;// 发布状态（1：未发布，2：已发布）
  @NotBlank(message = "标签不能为空")
  private List<Long> labelList;// 标签集合
  @NotBlank(message = "图片不能为空")
  private List<TopicImsageParameter> imsageList;// 图片集合
  private List<TopicInviteParameter> inviteList;// 邀请列表


}
