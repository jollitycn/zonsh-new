package user.mapper;

import user.entity.UserSearch;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;

import result.vo.search.SearchContentResult;
import result.vo.search.SearchResult;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xc
 * @since 2019-07-10
 */
public interface UserSearchMapper extends BaseMapper<UserSearch> {

	List<SearchContentResult> getSearchTopOractivityList(
			@Param(value = "searchKey")String searchKey);

	List<SearchResult> getSearchkey();

}
