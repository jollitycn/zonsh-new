package result.vo.admin;

import java.util.List;

import lombok.Data;

/**
* @author Xc
* @version 创建时间：2019年7月12日 下午1:27:51
* @ClassName 类名称
* @Description 类描述
*/
@Data
public class RolesDeatilResult {

	private Long rid;
	
	private String roleCode;
	
	private String roleName;
	
	private List<RoleMode> roleModeList;
	
}


