package request;

import java.util.List;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
* @author Xc
* @version 创建时间：2019年6月12日 上午9:57:50
* @ClassName 类名称
* @Description 类描述
*/
@ApiModel(value="回答请求参数对象",description="回答请求参数对象")
public class AnswerRequest {

	@ApiModelProperty(value="回答id",name="aid",required=true,example = "123")
	private Long aid;
	
	@ApiModelProperty(value="问题id",name="tid",required=true,example = "123")
	private Long tid;
	
	@ApiModelProperty(value="回答标题",name="answerTitle",required=true)
	private String answerTitle;

	@ApiModelProperty(value="回答内容",name="content",required=true)
	private String content;

	@ApiModelProperty(value="提交状态 1草稿 3发布(进入审核)",name="status",required=true,example = "1")
	private Integer status;

	@ApiModelProperty(value="图片列表",name="imageList")
	private List<String> imageList;

	public Long getAid() {
		return aid;
	}

	public void setAid(Long aid) {
		this.aid = aid;
	}

	public Long getTid() {
		return tid;
	}

	public void setTid(final Long tid) {
		this.tid = tid;
	}

	
	
	public String getAnswerTitle() {
		return answerTitle;
	}

	public void setAnswerTitle(String answerTitle) {
		this.answerTitle = answerTitle;
	}

	public String getContent() {
		return content;
	}

	public void setContent(final String content) {
		this.content = content;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<String> getImageList() {
		return imageList;
	}

	public void setImageList(final List<String> imageList) {
		this.imageList = imageList;
	}


}


