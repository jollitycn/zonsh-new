package request.admin;

import java.util.List;

import lombok.Data;

/**
* @author Xc
* @version 创建时间：2019年7月12日 下午1:59:06
* @ClassName 类名称
* @Description 类描述
*/
@Data
public class RoleParam {
	
//	private Long rid;
	
	private List<RoleDetailParam>  roleDetailList;
	
}


