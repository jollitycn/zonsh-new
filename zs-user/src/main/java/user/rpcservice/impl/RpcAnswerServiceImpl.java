package user.rpcservice.impl;

import java.util.List;

import org.springframework.stereotype.Component;
import com.baomidou.mybatisplus.plugins.Page;
import constant.Constant;
import result.vo.MyAnswerResult;
import result.vo.comment.MyAnswerWithTopicResult;
import user.rpcservice.RpcAnswerService;

@Component
public class RpcAnswerServiceImpl implements RpcAnswerService{

	@Override
	public List<MyAnswerResult> getMyAnswerListRpc(Long uid, Integer status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long countAnswerLikeTotalByUid(Long uid) {
		System.out.println("获取点赞数量服务不可用");
		return Constant.SYSTEM_ZERO_LONG;
	}

	@Override
	public Long countCommentLikeTotalByUid(Long uid) {
		System.out.println("获取评论数量服务不可用");
		return Constant.SYSTEM_ZERO_LONG;
	}

	@Override
	public Page<MyAnswerWithTopicResult> listNormalAnswerPageByUid(Long uid, Integer pageNum, Integer pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

}
