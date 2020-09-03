package user.rpcservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import result.vo.TopicResult;
import result.vo.question.QuestionResult;

/**
 * @author wangJin
 *
 * @date 2019年5月31日 下午5:54:24
 *
 */
@FeignClient(value = "question")
public interface RpcQuestionService {

	@GetMapping("/message/topicDetail")
	QuestionResult topicMessageInfo(
			@RequestParam(value = "uid")Long uid,
			@RequestParam(value = "tid")Long tid);

}
