package result.vo.question;

import java.util.List;

import lombok.Data;

/**
* @author Xc
* @version 创建时间：2019年7月11日 下午3:05:10
* @ClassName 类名称
* @Description 类描述
*/
@Data
public class QuestionResult {

	  private Long tid;// 问题id
	  private String topicContent;// 问题内容
	  private Integer isAnswer;// 是否回答过 1回答过  0否 2有草稿
//	  private Integer inviteCount;// 邀请数
	  private Integer heatCount;// 热度
	  private Integer replyCount;// 回答数
	  private List<String> urlList;// 话题图片
	/**
	 * 收藏标识
	 */
	private Integer isCollection;
	
}


