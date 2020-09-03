package result.vo.admin;

import java.util.List;

import lombok.Data;

/**
* @author Xc
* @version 创建时间：2019年7月12日 下午1:34:59
* @ClassName 类名称
* @Description 类描述
*/
@Data
public class RoleMode {

	private Long rid;
	
	private Long mid;
	
	private Long rdid;

	private String icon;
	
	private String menuCode;
	
	private String menuName;

	private String routeName;
	
	private List<RolePage> pageList;
}


