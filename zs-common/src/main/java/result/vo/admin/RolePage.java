package result.vo.admin;

import lombok.Data;

/**
* @author Xc
* @version 创建时间：2019年7月12日 下午1:34:59
* @ClassName 类名称
* @Description 类描述
*/
@Data
public class RolePage {

	private Long rdid;

	private String icon;
	
	private String menuCode;
	
	private String menuName;

	private String routeName;
	
	private String url;
	
	private Integer read;
	
	private Integer write;
}


