package result.vo.admin;

import java.util.List;

import lombok.Data;

/**
* @author Xc
* @version 创建时间：2019年7月12日 上午11:25:17
* @ClassName 类名称
* @Description 类描述
*/
@Data
public class MenuResult {

	private Long mid;
	
	private String menuCode;
	
	private String menuName;
	
	private String icon;
	
	private Integer menuLevel;
	
	private List<SecondMenu> secondMenuList;
	
}


