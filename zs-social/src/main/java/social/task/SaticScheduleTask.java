package social.task;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
* @author Xc
* @version 创建时间：2019年6月20日 上午10:29:19
* @ClassName 类名称
* @Description 类描述
*/

@Component
public class SaticScheduleTask {
	
//	@Autowired
//	protected IAnswerService answerService;
	
	
//    //3.添加定时任务
////    @Scheduled(cron = "0/5 * * * * ?")
//    //或直接指定时间间隔，例如：5秒
//    @Scheduled(fixedRate=5000)
//    private void configureTasks() {
//        System.err.println("执行静态定时任务时间: " + LocalDateTime.now());
//        System.out.println("1111111111111111111111111");
//    }

	/**
	 * 每一秒运行一次
	 */
//	@Scheduled(fixedRate = 60000 )
//    public void printDate(){
//    	//执行排序算法，更新回答排序值
//    	answerService.updateSort();
//
//    	System.out.println("回答排序值更新完成！！！");
//    }

}
