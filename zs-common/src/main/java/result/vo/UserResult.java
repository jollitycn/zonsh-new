package result.vo;

import lombok.Data;

/**
* @author Xc
* @version 创建时间：2019年5月28日 下午4:04:44
* @ClassName 类名称
* @Description 类描述
*/
@Data
public class UserResult {
	
	private Long uid;

	private String uToken;
	
	private String language;
	
	private String version;
	
	private String from;
	
	private String headUrl;

	/**
	 * 个人简介
	 */
	private String userSignature;
	
	private String uname;
	
	private Integer gender;
	
	/**
	 * 是否新注册用户 0否 1是
	 */
	private Integer isRegister;
	
	private Integer status;

	/**
	 * 关注数
	 */
	private Long followCount;

	/**
	 * 粉丝数
	 */
	private Long fansCount;

	/**
	 * 赞同数（回答总赞数）
	 */
	private Long likeCount;
}


