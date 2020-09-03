package util;

import java.io.IOException;
import java.util.Random;

import org.json.JSONException;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;

/**
 * @author Xc
 * @version 创建时间：2019年5月29日 上午10:34:45
 * @ClassName 腾讯短信服务工具类
 * @Description 类描述
 */
public class TenCentSmsUtil {

	// 短信应用 SDK AppID
	private static int appid = 1400214242; // SDK AppID 以1400开头

	// 短信应用 SDK AppKey
	private static String appkey = "d9ac63f6a37538a366f6a07ad0f08408";

	// 需要发送短信的手机号码
//	private String[] phoneNumbers = { "21212313123", "12345678902", "12345678903" };

	// 短信模板 ID，需要在短信应用中申请
	private int templateId = 7839; // NOTE: 这里的模板 ID`7839`只是示例，真实的模板 ID
									// 需要在短信控制台中申请

	// 签名
	private String smsSign = "腾讯云"; // NOTE:
									// 签名参数使用的是`签名内容`，而不是`签名ID`。这里的签名"腾讯云"只是示例，真实的签名需要在短信控制台申请

	/**
	 * 发送短信验证码
	 * 
	 * @return 验证码
	 */
	public static String sendCode(String phone) {
		try {
			//获取6位的随机验证码
			String code = TenCentSmsUtil.getRandomNum();

			// 需要发送短信的手机号码
			String[] phoneNumbers = {phone};
			
			SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
			SmsSingleSenderResult result = ssender.send(0, "86", phoneNumbers[0], "【腾讯云】您的验证码是: " + code, "", "");
			if (result != null) {
				System.out.println(result);
			}

			return code;
		} catch (HTTPException e) {
			// HTTP 响应码错误
			e.printStackTrace();
		} catch (JSONException e) {
			// JSON 解析错误
			e.printStackTrace();
		} catch (IOException e) {
			// 网络 IO 错误
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * 随机生成六位数验证码 
	 * 
	 * @return
	 * 
	 */

	public static String getRandomNum() {

		Random r = new Random();

		// (Math.random()*(999999-100000)+100000)
		Integer code = r.nextInt(900000) + 100000;
		return code.toString();

	}

	
	/*public static void main(String[] args) {
		TenCentSmsUtil.sendCode("17603070018");
	}*/
	

}
