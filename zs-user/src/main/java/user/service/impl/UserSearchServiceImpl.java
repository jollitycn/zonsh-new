package user.service.impl;

import user.entity.UserSearch;
import user.mapper.UserSearchMapper;
import user.service.IUserSearchService;
import util.ZsUtil;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import result.vo.search.SearchContentResult;
import result.vo.search.SearchResult;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xc
 * @since 2019-07-10
 */
@Service
public class UserSearchServiceImpl extends ServiceImpl<UserSearchMapper, UserSearch> implements IUserSearchService {

	@Override
	public List<SearchContentResult> getSearchTopOractivityList(String searchKey) {
//		Page<SearchResult> page=new Page<>(pageNum,pageSize);
		
		//查询搜索内容
		List<SearchContentResult> result=baseMapper.getSearchTopOractivityList("%"+searchKey+"%");
		
		//过滤无用的搜索关键字(搜索结果为空),过滤空搜索关键字
		if(result.size()>0&&ZsUtil.isNotEmpty(searchKey)){
			//记录搜索参数
			UserSearch insert=new UserSearch();
			insert.setSearchContent(searchKey);
//			insert.setSearchType(searchType);
			insert.setCreateTime(new Date());
			baseMapper.insert(insert);
		}
		
		return result;
	}

	@Override
	public List<SearchResult> getSearchkey() {
		
		//搜索关键字排序算法  搜索次数/（当前时间-最近一次搜索时间<小时>）+1
		
		
		return baseMapper.getSearchkey();
	}

}
