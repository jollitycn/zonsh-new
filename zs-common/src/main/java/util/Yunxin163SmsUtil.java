package util;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
* @author Xc
* @version 创建时间：2019年5月29日 下午4:29:24
* @ClassName 163云信短信工具类
* @Description 类描述
*/
public class Yunxin163SmsUtil {

	 //发送验证码的请求路径URL
    	private static final String
            SERVER_URL="https://api.netease.im/sms/sendtemplate.action";
	
	
	    //网易云信分配的账号，请替换你在管理后台应用下申请的Appkey
	    private static final String
	            APP_KEY="dee48072f1b3a1f3f6946c705c8b3f63";
	    //网易云信分配的密钥，请替换你在管理后台应用下申请的appSecret
	    private static final String APP_SECRET="b064886774e5";
	    //随机数
	    private static final String NONCE="123456";
	    //短信模板ID
	    private static final String TEMPLATEID="14812085";
	   
	    
	    //手机号，接收者号码列表，JSONArray格式，限制接收者号码个数最多为100个
//	    private static final String MOBILES="['17603070018']";
	    //短信参数列表，用于依次填充模板，JSONArray格式，每个变量长度不能超过30字,对于不包含变量的模板，不填此参数表示模板即短信全文内容
//	    private static final String PARAMS="['654321']";

	    //手机号，接收者号码列表，JSONArray格式，限制接收者号码个数最多为100个
	    private static final String MOBILES="['***']";
	    //短信参数列表，用于依次填充模板，JSONArray格式，每个变量长度不能超过30字,对于不包含变量的模板，不填此参数表示模板即短信全文内容
	    private static final String PARAMS="['**']";
	    
	    public static String sendCode(String phone)  {

	    	//生成随机验证码
	    	String code=TenCentSmsUtil.getRandomNum();	
	    	
	        DefaultHttpClient httpClient = new DefaultHttpClient();
	        HttpPost httpPost = new HttpPost(SERVER_URL);
	        String curTime = String.valueOf((new Date()).getTime() / 1000L);
	        /*
	         * 参考计算CheckSum的java代码，在上述文档的参数列表中，有CheckSum的计算文档示例
	         */
	        String checkSum = CheckSumBuilder.getCheckSum(APP_SECRET, NONCE, curTime);

	        // 设置请求的header
	        httpPost.addHeader("AppKey", APP_KEY);
	        httpPost.addHeader("Nonce", NONCE);
	        httpPost.addHeader("CurTime", curTime);
	        httpPost.addHeader("CheckSum", checkSum);
	        httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

	        // 设置请求的的参数，requestBody参数
	        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
	        /*
	         * 1.如果是模板短信，请注意参数mobile是有s的，详细参数配置请参考“发送模板短信文档”
	         * 2.参数格式是jsonArray的格式，例如 "['13888888888','13666666666']"
	         * 3.params是根据你模板里面有几个参数，那里面的参数也是jsonArray格式
	         */
	        nvps.add(new BasicNameValuePair("templateid", TEMPLATEID));
	        nvps.add(new BasicNameValuePair("mobiles", MOBILES.replace("***", phone)));
	        nvps.add(new BasicNameValuePair("params", PARAMS.replace("**", code)));

	        try {
				httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
				// 执行请求
				HttpResponse response = httpClient.execute(httpPost);
				/*
				 * 1.打印执行结果，打印结果一般会200、315、403、404、413、414、500
				 * 2.具体的code有问题的可以参考官网的Code状态表
				 */
				String result=EntityUtils.toString(response.getEntity(), "utf-8");
				if(result.contains("200")){
					return code;
				}
	        } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	        
	        return null;
	    }
	    
	    
	   /* public static void main(String[] args) {
			String aaa=Yunxin163SmsUtil.sendCode("17603070018");
			System.out.println(aaa);
		}*/
}
	



