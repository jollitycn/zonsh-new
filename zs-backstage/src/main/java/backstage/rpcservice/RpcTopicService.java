package backstage.rpcservice;


import com.baomidou.mybatisplus.plugins.Page;
import feign.Headers;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import request.TopicLabelParameter;
import request.TopicParameter;
import result.vo.TopLabelResult;
import result.vo.TopicHomePageResult;

/**
 * @author wangJin
 *
 * @date 2019年5月31日 下午5:54:24
 *
 */
@FeignClient(value = "question")
public interface RpcTopicService {

	@GetMapping(value = "/topicList")
	Page<TopicHomePageResult> getTopicList(
			@RequestParam(value = "pageNum")Integer pageNum, 
			@RequestParam(value = "pageSize")Integer pageSize, 
			@RequestParam(value = "mark")Integer mark,
			@RequestParam(value = "startTime")String startTime,
			@RequestParam(value = "endTime")String endTime, 
			@RequestParam(value = "tlid")Long tlid, 
			@RequestParam(value = "searchKey")String searchKey, 
			@RequestParam(value = "status")Integer status);

	@PostMapping(value = "/addTopic")
    @Headers("Content-Type: application/json")
	Boolean addTopic(@RequestBody TopicParameter param);

	@PutMapping(value = "/upOrdownTopic")
	Boolean upOrdownTopic(
			@RequestParam(value = "tid")Long tid, 
			@RequestParam(value = "status")Integer status);
	
	@DeleteMapping(value = "/delTopic")
	Boolean deleteTopic(@RequestParam(value = "tid")Long tid);

	@PostMapping(value = "/addTopiclabel")
	@Headers("Content-Type: application/json")
	Boolean addLabel(@RequestBody TopicLabelParameter param);

	@GetMapping(value = "/labelList")
	List<TopLabelResult> getLabelList(
			@RequestParam(value = "searchKey")String searchKey);

	@DeleteMapping(value = "/delTopicLabel")
    @Headers("Content-Type: application/json")
	Boolean deleteLabel(@RequestBody List<Long> list);
	
	

}
