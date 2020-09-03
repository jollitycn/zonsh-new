package result.vo.message;
/**
* @author Xc
* @version 创建时间：2019年6月28日 下午2:47:25
* @ClassName 类名称
* @Description 类描述
*/
public class MessageTypeResult {

	//消息类型
	private Integer messageType;
	
	//消息标题
	private String messageTitle;
	
	//消息内容
	private String messageContent;
	
	//新消息数量
	private String newMessageCount;
	
	//最近更新时间
	private String lastUpdateTime;
	
	//关联id
	private Long relationId;
	
	public Long getRelationId() {
		return relationId;
	}

	public void setRelationId(Long relationId) {
		this.relationId = relationId;
	}

	public Integer getMessageType() {
		return messageType;
	}

	public void setMessageType(Integer messageType) {
		this.messageType = messageType;
	}

	public String getMessageTitle() {
		return messageTitle;
	}

	public void setMessageTitle(String messageTitle) {
		this.messageTitle = messageTitle;
	}

	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

	public String getNewMessageCount() {
		return newMessageCount;
	}

	public void setNewMessageCount(String newMessageCount) {
		this.newMessageCount = newMessageCount;
	}

	public String getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(String lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	
	
}


