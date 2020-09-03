package social.bdutil;



import org.json.JSONException;
import org.json.JSONObject;

import com.baidu.aip.contentcensor.AipContentCensor;

/**
* @author Xc
* @version 创建时间：2019年6月13日 下午4:10:50
* @ClassName 类名称
* @Description 类描述
*/
public class BaiduUtil {

	//设置APPID/AK/SK
    public static final String APP_ID = "16481741";
    public static final String API_KEY = "1uv6OKc3Dn8BY9Aj39b8NVeV";
    public static final String SECRET_KEY = "pRh4lPwyIyR0r8jmQ0bPXFaCY5UDcAfB";
    
    private static final AipContentCensor client=new AipContentCensor(APP_ID, API_KEY, SECRET_KEY);
    
    /*
     * static{
    	 // 初始化一个AipImageCensor
        AipContentCensor client = new AipContentCensor(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
        client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
        client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
        // 也可以直接通过jvm启动参数设置此环境变量
        System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");

        // 调用接口
        String path = "test.jpg";
        JSONObject res = client.antiPorn(path);
        System.out.println(res.toString(2));
    	
    }
    */
    
    public static Integer checkContent(String content) {

//        String content = "今天天气真好";
        JSONObject response = client.antiSpam(content, null);
        try {
        	System.out.println(response.get("result"));
        	String result=response.get("result").toString();
//        	String log_id=response.get("log_id").toString();
        	JSONObject resultJson=new JSONObject(result);
        	return resultJson.getInt("spam");
        	
//			System.out.println(spam);
//			if(spam==1){
//				
//			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//        System.out.println(response.toString());
        return 2;
    }
    
	public static void main(String[] args) {
		
//		String aa="<img src=\"https://zs-1256779886.cos.ap-shenzhen-fsi.myqcloud.com/zs/06947ECE-87BE-433F-9C57-73DD0C8F4521Screenshot_2019-06-20-11-18-14_cn.itcast.test.chat.png\"/><img src=\"https://zs-1256779886.cos.ap-shenzhen-fsi.myqcloud.com/zs/C89C4373-EA3D-4AE9-957A-3381B400A227Screenshot_2019-06-20-11-18-05_cn.itcast.test.chat.png\"/><img src=\"https://zs-1256779886.cos.ap-shenzhen-fsi.myqcloud.com/zs/1AE33C50-222B-4195-8BA4-72AD601D3200Screenshot_2019-06-20-13-37-27_com.bis.regain.png\"/><img src=\"https://zs-1256779886.cos.ap-shenzhen-fsi.myqcloud.com/zs/8D25B37E-9C2C-43B0-8131-03E39641BF39Screenshot_2019-06-12-17-25-50_com.sendtion.xrichtext.png\"/><img src=\"https://zs-1256779886.cos.ap-shenzhen-fsi.myqcloud.com/zs/4C5AD5D0-A186-440F-A1C8-7B42027C8769Screenshot_2019-06-12-17-12-07_com.example.zhouqiong.richeditotandroid.png\"/>";
		
		//0表示非违禁，1表示违禁，2表示建议人工复审
		Integer i=BaiduUtil.checkContent("aa");
		if(i==0){
			System.out.println("内容健康");
		}else if(i==1){
			System.out.println("违禁");
		}else{
			System.out.println("人工复审");
		}
	}
}


