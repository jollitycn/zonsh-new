package user.service;

import user.entity.UserSearch;

import java.util.List;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;

import result.vo.search.SearchContentResult;
import result.vo.search.SearchResult;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xc
 * @since 2019-07-10
 */
public interface IUserSearchService extends IService<UserSearch> {

	/**
	 * 首页搜索
	 * @param searchKey 搜索关键字
	
	 * @return
	 */
	List<SearchContentResult> getSearchTopOractivityList(String searchKey);

	/**
	 * 获取排名前5的搜索关键字
	 * @return
	 */
	List<SearchResult> getSearchkey();

}
