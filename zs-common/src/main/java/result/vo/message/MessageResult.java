package result.vo.message;

import lombok.Data;

/**
* @author Xc
* @version 创建时间：2019年6月28日 下午3:13:22
* @ClassName 类名称
* @Description 类描述
*/
@Data
public class MessageResult {

	//消息id
	private Long mid;
	
	//消息标题
	private String messageTitle;
	
	//是否官方0 不是 1是
	private Integer isAdmin;
	
	//话题内容
	private String topicContent;
	
	//消息创建时间
	private String createTime;
	
	//是否回答过
	private Integer isAnswer;
	
	//是否查看过改消息
	private Integer isView;
	
	//关联id
	private Long relationId;
	
	//关联回答id
	private Long aid;
	
	
}


