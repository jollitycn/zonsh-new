package result.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
* @author Xc
* @version 创建时间：2019年6月5日 下午5:22:30
* @ClassName 类名称
* @Description 类描述
*/
@ApiModel(value = "被邀请用户返回类")
@Data
public class InvitationUserResult {

	@ApiModelProperty(value="用户id",name="uid",example = "123")
	private Long uid;
	
	@ApiModelProperty(value="用户名",name="uname")
	private String uname;
	
	@ApiModelProperty(value="被邀请总数",name="invitationCount",example = "123")
	private Integer invitationCount;  
	
	@ApiModelProperty(value="回答总数",name="replyCount",example = "123")
	private Integer replyCount;    
	
	@ApiModelProperty(value="评论总数",name="commentCount",example = "123")
	private Integer commentCount; 
	
	@ApiModelProperty(value="回答观看总数",name="replyViewCount",example = "123")
	private Integer replyViewCount; 
	
	@ApiModelProperty(value="最近登录时间",name="lastLoginTime")
	private String lastLoginTime;

	@ApiModelProperty(value="状态（1:未邀请，2：已邀请）",name="status")
  private Integer status;
	
}


