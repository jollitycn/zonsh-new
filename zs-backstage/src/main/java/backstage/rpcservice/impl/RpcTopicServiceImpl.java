package backstage.rpcservice.impl;

import backstage.rpcservice.RpcTopicService;
import com.baomidou.mybatisplus.plugins.Page;
import java.util.List;
import request.TopicLabelParameter;
import request.TopicParameter;
import result.vo.TopLabelResult;
import result.vo.TopicHomePageResult;

/**
 * @author wangJin
 *
 * @date 2019年5月31日 下午5:56:30
 *
 */
public class RpcTopicServiceImpl implements RpcTopicService{

	@Override
	public Page<TopicHomePageResult> getTopicList(Integer pageNum, Integer pageSize, Integer mark, String startTime,
			String endTime, Long tlid, String searchKey, Integer status) {
		// TODO Auto-generated method stub
		System.out.println("服务不可用");
		return null;
	}

	@Override
	public Boolean addTopic(TopicParameter param) {
		// TODO Auto-generated method stub
		System.out.println("服务不可用");
		return null;
	}

	@Override
	public Boolean upOrdownTopic(Long tid, Integer status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteTopic(Long tid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean addLabel(TopicLabelParameter param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TopLabelResult> getLabelList(String searchKey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteLabel(List<Long> list) {
		// TODO Auto-generated method stub
		return null;
	}

}
