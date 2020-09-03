package result.vo.search;
/**
* @author Xc
* @version 创建时间：2019年7月10日 下午1:27:47
* @ClassName 类名称
* @Description 类描述
*/

import lombok.Data;

@Data
public class SearchResult{
	
	private String searchContent;
	
	private Integer searchCount;
	
	private Integer  searchTime;
	
	private String searchSort;
}
