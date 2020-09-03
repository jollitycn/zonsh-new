package result.vo;
/**
* @author Xc
* @version 创建时间：2019年6月21日 上午10:41:42
* @ClassName 类名称
* @Description 类描述
*/
public class SortParam {
	
	//话题id
	private Long tid;
	
	//回答id
	private Long aid;

	//话题热度
	private Integer topHot;
	
	//回答数
	private Integer answerCount;
	
	//回答查看数
	private Integer answerViewCount;
	
	//回答点赞数
	private Integer answerLikeCount;
	
	//评论数
	private Integer commentCount;
		
	//评论点赞数
	private Integer commentLikeCount;
	
	//发布时间
	private Long publishTime;
	
	

	public Integer getAnswerLikeCount() {
		return answerLikeCount;
	}

	public void setAnswerLikeCount(Integer answerLikeCount) {
		this.answerLikeCount = answerLikeCount;
	}

	public Long getTid() {
		return tid;
	}

	public void setTid(Long tid) {
		this.tid = tid;
	}

	public Long getAid() {
		return aid;
	}

	public void setAid(Long aid) {
		this.aid = aid;
	}

	public Integer getTopHot() {
		return topHot;
	}

	public void setTopHot(Integer topHot) {
		this.topHot = topHot;
	}

	public Integer getAnswerCount() {
		return answerCount;
	}

	public void setAnswerCount(Integer answerCount) {
		this.answerCount = answerCount;
	}

	public Integer getAnswerViewCount() {
		return answerViewCount;
	}

	public void setAnswerViewCount(Integer answerViewCount) {
		this.answerViewCount = answerViewCount;
	}

	public Integer getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}

	public Integer getCommentLikeCount() {
		return commentLikeCount;
	}

	public void setCommentLikeCount(Integer commentLikeCount) {
		this.commentLikeCount = commentLikeCount;
	}

	public Long getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Long publishTime) {
		this.publishTime = publishTime;
	}
	
	
}


