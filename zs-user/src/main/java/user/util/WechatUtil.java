//package user.util;
//
//import java.io.BufferedOutputStream;
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.io.OutputStream;
//import java.net.HttpURLConnection;
//import java.net.URI;
//import java.net.URL;
//import java.security.MessageDigest;
//import java.security.NoSuchAlgorithmException;
//import java.util.Arrays;
//import java.util.Map;
//import java.util.Properties;
//import java.util.UUID;
//
//import javax.net.ssl.HttpsURLConnection;
//
//import org.apache.http.HttpEntity;
//import org.apache.http.HttpResponse;
//import org.apache.http.client.ClientProtocolException;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.entity.mime.MultipartEntityBuilder;
//import org.apache.http.entity.mime.content.FileBody;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.DefaultHttpClient;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.util.EntityUtils;
//
////import org.apache.log4j.Logger;
//import net.sf.json.JSONObject;
//
//@SuppressWarnings("deprecation")
//public class WechatUtil {
//	
////	private static Logger logger = Logger.getLogger(WechatUtil.class);
//
//	//从微信后台拿到APPID和APPSECRET 并封装为常量
//    public static String APPID = null;
//    public static String APPSECRET = null;
//    public static String CALLBACKURL = null;
//    public static String SERVERURL = null;
//    public static String TMP_FILE_PATH=null;
//    public static String TEMPLATE_ID=null;
//    public static String CMD=null;
//    public static String FILE_UPLOAD_ADDRESS=null;
//    
//	
//	// 与开发模式接口配置信息中的Token保持一致.
//    private static String token = "weixinCourse";
//    
//    static {
//    	String FileName = "WxTokenUtil.properties";
//    	Properties prop = new Properties();// 属性集合对象
//        //获取文件流
//    	InputStream fis = WechatUtil.class.getClassLoader().getResourceAsStream(FileName);
//    	try {
//			prop.load(fis);
//			fis.close();// 关闭流
//			APPID = prop.getProperty("APPID");
//			APPSECRET = prop.getProperty("APPSECRET");
//			CALLBACKURL = prop.getProperty("CALLBACKURL");
//			SERVERURL = prop.getProperty("SERVERURL");
//			TMP_FILE_PATH=prop.getProperty("TMP_FILE_PATH");
//			TEMPLATE_ID=prop.getProperty("TEMPLATE_ID");
//			CMD=prop.getProperty("CMD");
//			FILE_UPLOAD_ADDRESS=prop.getProperty("FILE_UPLOAD_ADDRESS");
//		} catch (IOException e) {
//			e.printStackTrace();
////			logger.info("加载" + FileName + "出现异常");
//		}
//    }
//    
//  //实用synchronized static可以防止同时被多实例化
//    public synchronized static String getAccessToken() {
//        //保存access_token文件名字
//        String FileName = "WxTokenUtil.properties";
//        try {
//            // 从文件中获取token值及时间
//            Properties prop = new Properties();// 属性集合对象
//             //获取文件流
//            InputStream fis = WechatUtil.class.getClassLoader().getResourceAsStream(FileName);
//            prop.load(fis);// 将属性文件流装载到Properties对象中
//            fis.close();// 关闭流
//            //获取Appid，APPsecret
//            String APPID = prop.getProperty("APPID");
//            String APPSECRET = prop.getProperty("APPSECRET");
//            // 获取accesstoken，初始值为空，第一次调用之后会把值写入文件
//            String access_token = prop.getProperty("access_token");
//            String expires_in = prop.getProperty("expires_in");
//            String last_time = prop.getProperty("last_time");
// 
//            int int_expires_in = 0;
//            long long_last_time = 0;
// 
//            try {
//                int_expires_in = Integer.parseInt(expires_in);
//                long_last_time = Long.parseLong(last_time);
// 
//            } catch (Exception e) {
// 
//            }
//            //得到当前时间
//            long current_time = System.currentTimeMillis();
//            // 每次调用，判断expires_in是否过期，如果token时间超时，重新获取，expires_in有效期为7200
//            if ((current_time - long_last_time) / 1000 >= int_expires_in) {
//                //获取token url
//                String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="
//                        + APPID + "&secret=" + APPSECRET;
//                //发送http请求得到json流
////                JSONObject jobject = httpRequest(url);
//                
//                JSONObject jobject = doGetJson(url);
//                //从json流中获取access_token
//                String  j_access_token = (String) jobject.get("access_token");
//                Integer  j_expires_in = (Integer) jobject.get("expires_in");
// 
//                //保存access_token
//                if (j_access_token != null && j_expires_in != null) {
//                    prop.setProperty("access_token", j_access_token);
//                    prop.setProperty("expires_in", j_expires_in.toString());
//                    prop.setProperty("last_time", System.currentTimeMillis() + "");
// 
//                    URL url_ = WechatUtil.class.getClassLoader().getResource(FileName);
//                    FileOutputStream fos = new FileOutputStream(new File(url_.toURI()));
//                    prop.store(fos, null);
//                    fos.close();// 关闭流
//                }
//                //如果已经过期返回获取到的access_token
//                return j_access_token;
//            } else {
//                //如果没有过期，返回从文件中读取的access_token
//                return access_token;
//            }
//        } catch (Exception e) {
//        	e.printStackTrace();
//            return null;
//        }
// 
// 
//    }
// 
//    // 获取accesstoken
//    public synchronized static JSONObject httpRequest(String requestUrl) {
//        JSONObject jsonObject = null;
//        StringBuffer buffer = new StringBuffer();
//        try {
// 
//            URL url = new URL(requestUrl);
//            HttpsURLConnection httpUrlConn = (HttpsURLConnection) url
//                    .openConnection();
// 
//            httpUrlConn.setDoOutput(true);
//            httpUrlConn.setDoInput(true);
//            httpUrlConn.setUseCaches(false);
//            // 设置请求方式（GET/POST）
//            httpUrlConn.setRequestMethod("GET");
//            httpUrlConn.connect();
// 
//            // 将返回的输入流转换成字符串
//            InputStream inputStream = httpUrlConn.getInputStream();
//            InputStreamReader inputStreamReader = new InputStreamReader(
//                    inputStream, "utf-8");
//            BufferedReader bufferedReader = new BufferedReader(
//                    inputStreamReader);
// 
//            String str = null;
//            while ((str = bufferedReader.readLine()) != null) {
//                buffer.append(str);
//            }
//            bufferedReader.close();
//            inputStreamReader.close();
//            // 释放资源
//            inputStream.close();
//            inputStream = null;
//            httpUrlConn.disconnect();
////            jsonObject = JSONObject.parseObject(buffer.toString());
// 
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
// 
//        return jsonObject;
//    }
//    
//    public static String httpsRequest(String requestUrl, String requestMethod, String outputStr, String contentType){
//        try {
//            URL url = new URL(requestUrl);
//            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
//            conn.setDoOutput(true);
//            conn.setDoInput(true);
//            conn.setUseCaches(false);
//            // 设置请求方式（GET/POST）
//            conn.setRequestMethod(requestMethod);
//            conn.setRequestProperty("content-type", contentType);
//            // 当outputStr不为null时向输出流写数据
//            if (null != outputStr) {
//                OutputStream outputStream = conn.getOutputStream();
//                // 注意编码格式
//                outputStream.write(outputStr.getBytes("UTF-8"));
//                outputStream.close();
//            }
//            // 从输入流读取返回内容
//            InputStream inputStream = conn.getInputStream();
//            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
//            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//            String str = null;
//            StringBuffer buffer = new StringBuffer();
//            while ((str = bufferedReader.readLine()) != null) {
//                buffer.append(str);
//            }
//            // 释放资源
//            bufferedReader.close();
//            inputStreamReader.close();
//            inputStream.close();
//            inputStream = null;
//            conn.disconnect();
//            return buffer.toString();
//        } catch (Exception e) {
//        	e.printStackTrace();
////            logger.info("请求发送失败");
//        }
//        return null;
//    }
//
//   @SuppressWarnings("resource")
//   public static JSONObject doGetJson(String url) throws ClientProtocolException, IOException{
//	   JSONObject jsonObject=null;
//	   DefaultHttpClient client=new DefaultHttpClient();
//	   HttpGet httpget=new HttpGet(url);
//	   HttpResponse response=client.execute(httpget); 
//	   HttpEntity entity=response.getEntity();
//	   if(entity != null){
//		   String result=	EntityUtils.toString(entity,"UTF-8");
//		   jsonObject=JSONObject.fromObject(result);
//	   }
//	   httpget.releaseConnection();
//	   return jsonObject;
//   }
//   
//   @SuppressWarnings("resource")
//   public static JSONObject doPostJson(String url) throws ClientProtocolException, IOException{
//	   JSONObject jsonObject=null;
//	   DefaultHttpClient client=new DefaultHttpClient();
//	   HttpPost httppost=new HttpPost(url);
//	   HttpResponse response=client.execute(httppost); 
//	   HttpEntity entity=response.getEntity();
//	   if(entity != null){
//		   String result=	EntityUtils.toString(entity,"UTF-8");
//		   jsonObject=JSONObject.fromObject(result);
//	   }
//	   httppost.releaseConnection();
//	   return jsonObject;
//   }
//   
//	/**
//	 * 生成时间戳
//	 * @author luxiaopeng
//	 * @return
//	 */
//	public static String createTimestamp() {
//		return Long.toString(System.currentTimeMillis() / 1000);
//	}
//
//	/**
//	 * 生成随机字符串
//	 * @author luxiaopeng
//	 * @return
//	 */
//	public static String createNonceStr() {
//		return UUID.randomUUID().toString().replaceAll("-", "").substring(0, 32);
//	}
//
//	/**
//	 * 生成签名
//	 * @author luxiaopeng
//	 * @param timeStamp
//	 * @param nonceStr
//	 * @param appId
//	 * @param secret
//	 * @param url
//	 * @return
//	 */
//	public static String createSignature(String timeStamp, String nonceStr, String appId, String secret,
//			String url) {
//		String accessToken = getAccessToken(); // 获取sccess_token
//		String jsapiTicket = getJsapiTicket(accessToken); // 获取jsapi_ticket
//		return sign(jsapiTicket, nonceStr, timeStamp, url);
//	}
//
//	/**
//	 * 生成sha1签名
//	 * @author luxiaopeng
//	 * @param jsapiTicket
//	 * @param nonceStr
//	 * @param timeStamp
//	 * @param url
//	 * @return
//	 */
//	private static String sign(String jsapiTicket, String nonceStr, String timeStamp, String url) {
//		String sign = null;
//		String params = "jsapi_ticket=" + jsapiTicket
//				+ "&noncestr=" + nonceStr
//				+ "&timestamp=" + timeStamp
//				+ "&url=" + url;
//		try {
//			MessageDigest crypt = MessageDigest.getInstance("SHA-1");
//			crypt.reset();
//			crypt.update(params.getBytes("UTF-8"));
//			sign = byteToHex(crypt.digest());
//			return sign;
//		} catch (Exception e) {
////			logger.warn("微信生成签名出错" + e.getMessage());
//		}
//		return null;
//	}
//
//	/**
//	 * 字节数组转化成16进制字符串
//	 * @author luxiaopeng
//	 * @param src
//	 * @return
//	 */
//	public static String byteToHex(byte[] b) {
//		String str = "";
//		for (int i = 0; i < b.length; i++) {
//			String hex = Integer.toHexString(b[i] & 0xFF);
//			if (hex.length() == 1) {
//				hex = '0' + hex;
//			}
//			str = str + hex;
//		}
//		return str;
//	}
//
//	/**
//	 * 获得jsapi_ticket
//	 * @author luxiaopeng
//	 * @param accessToken
//	 * @return
//	 */
//	public static String getJsapiTicket(String accessToken) {
//		String urlString = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=" + accessToken + "&type=jsapi";
//		String jsapiTicket = null;
//		try {
//			JSONObject jsonObject = doGetJson(urlString);
//			jsapiTicket = (String) jsonObject.get("ticket");
//			return jsapiTicket;
//		} catch (Exception e) {
////			logger.warn("微信请求ticket出错" + e.getMessage());
//		}
//		return null;
//	}
//	
//	/**
//	 * 从微信服务器下载多媒体文件
//	 * @author luxiaopeng
//	 * @param serverId 服务器文件ID
//	 * @param dirPath 保存文件路径
//	 * @return
//	 * @throws Exception
//	 */
//	public static String downloadMedia(String serverId, String dirPath) throws Exception {
//		String filePath = null;
//		String accessToken = WechatUtil.getAccessToken();
//		String urlString = "http://file.api.weixin.qq.com/cgi-bin/media/get?access_token=" + accessToken + "&media_id=" + serverId;
//		// http://file.api.weixin.qq.com/cgi-bin/media/get?access_token=13_zPCWfHhlP80tXVcLk7Q9P47fU55sysAjfk5xyJYD9f3Fu33Su-XDKtoxVAFjiy9iX_cNfKkxl5BV21v9OFFZ-8_sLMf0be-e6bGjI9e3p0K4YWkbg2pvwxIaEKWMub_EDo3UAm7HJ29BHHavDNZgADAOYK&media_id=uI8P1kz4IvUh0Ii1vIA7QITxChNM1WgKvBQ_qVvhBCgl7lGvDH79fvLa_miURsju
////		String urlString = "http://file.api.weixin.qq.com/cgi-bin/media/get?access_token=13_zPCWfHhlP80tXVcLk7Q9P47fU55sysAjfk5xyJYD9f3Fu33Su-XDKtoxVAFjiy9iX_cNfKkxl5BV21v9OFFZ-8_sLMf0be-e6bGjI9e3p0K4YWkbg2pvwxIaEKWMub_EDo3UAm7HJ29BHHavDNZgADAOYK&media_id=uI8P1kz4IvUh0Ii1vIA7QITxChNM1WgKvBQ_qVvhBCgl7lGvDH79fvLa_miURsju";
//		
//		URL url = new URL(urlString);
//		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//		conn.setRequestMethod("GET");
//		conn.setDoInput(true);
//		conn.setDoOutput(true);
//		InputStream in = conn.getInputStream();
//		
//		File dir = new File(dirPath);
//		if (! dir.exists()) {
//			dir.mkdirs();
//		}
//		if (! dirPath.endsWith("/")) {
//			dirPath += "/";
//		}
//		
//		String contentDisposition = conn.getHeaderField("Content-disposition");
//		String wechatFileName = contentDisposition.substring(contentDisposition.indexOf("filename") + 10, contentDisposition.length() - 1);
//		filePath = dirPath + wechatFileName;
//		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
//		byte[] data = new byte[1024];
//		int len = -1;
//		while ((len = in.read(data)) != -1) {
//			bos.write(data, 0 ,len);
//		}
//		
//		bos.close();
//		in.close();
//		conn.disconnect();
//		
//		return filePath;
//	}
//	
////	/**
////	 * amr格式转换成mp3(集成ffmpeg环境)
////	 * @author luxiaopeng
////	 * @param src
////	 * @return 
////	 * @return
////	 * @throws IOException 
////	 */
////	public static JSONObject amr2mp3(String src, String dest) {
////		Runtime rt = Runtime.getRuntime();
////		File destFile = new File(dest);
////		if(destFile.exists()) {
////			destFile.delete();
////		}
////		// 本地 测试
//////		String cmd = "C:/Program Files/ffmpeg/bin/ffmpeg -i " + src + " " + dest;
////		// 正式
//////		String cmd = "ffmpeg -i " + src + " " + dest;
////		String cmd =CMD+" -i " + src + " " + dest;
////		
////		try {
////			Process proc = rt.exec(cmd);
////			InputStream stderr = proc.getErrorStream();
////			InputStreamReader isr = new InputStreamReader(stderr);
////			BufferedReader br = new BufferedReader(isr);
////			String line = null;
////			StringBuffer sb = new StringBuffer();
////			while ((line = br.readLine()) != null) {
////				sb.append(line);
////			}
////			
//////			logger.info("ffmpeg process command : " + cmd);
////			int exitVal = proc.waitFor();
//////			logger.info("ffmpeg process exitval : " + exitVal);
////			
////			if(exitVal == 0) {
////				String result = fileUpload(destFile);
////				if(result != null) {
////					JSONObject obj = JSONObject.fromObject(result);
//////					destFile.delete();
////					return JSONObject.fromObject(obj.get("data").toString());
////				}
////			}
////		} catch (Exception e) {
//////			logger.warn("语音格式转换异常" + e.getMessage());
////		}
////		return null;
////	}
//	
////	/**
////	 * 将文件上传至文件服务器
////	 * @author luxiaopeng
////	 * @param voice
////	 * @return 
////	 * @throws IOException
////	 */
////	public static String fileUpload(File file) throws IOException {
////		String result = null;
////		CloseableHttpClient httpclient = HttpClients.createDefault();
////		try {
////			HttpPost httpPost = new HttpPost(FILE_UPLOAD_ADDRESS);
////			FileBody fileBody = new FileBody(file);
////			HttpEntity reqEntity = MultipartEntityBuilder.create()
////					.addPart("file", fileBody).build();
////			httpPost.setEntity(reqEntity);
////			
////			CloseableHttpResponse response = httpclient.execute(httpPost);
////			
////			try {
////				logger.info(response.getStatusLine());
////				
////				HttpEntity resEntity = response.getEntity();
////				if (resEntity != null) {
////					 result = IOUtils.toString(resEntity.getContent());
////					 result = new String(result.getBytes(), "UTF-8");
////					 logger.info("response body : " + result);
////				}
////				EntityUtils.consume(resEntity);
////				if(! MyTools.isNullOrEmpty(result)) {
////					return result;
////				}
////			} finally {
////				response.close();
////			}
////		} catch (Exception e) {
////			e.printStackTrace();
////		} finally {
////			httpclient.close();
////		}
////		return null;
////	}
//	
////	/**
////	 * 发送模板消息
////	 * @param touser 接收者openid(必填)
////	 * @param url 跳转链接(非必填)
////	 * @param msg 消息(必填)
////	 * @return
////	 * @throws IOException 
////	 */
////	public static boolean sendTemplateMessage(String touser, String url, String remark, String good, String contentType) {
////		JSONObject body = new JSONObject();
////		body.put("touser", touser);
////		body.put("template_id", TEMPLATE_ID);
////		if(! MyTools.isNullOrEmpty(url)) {
////			body.put("url", url);
////		}
////		JSONObject firstObject = new JSONObject(); // first
////		firstObject.put("value", "亲爱的用户，您的项目有新的进展");
////		JSONObject goodObject = new JSONObject(); // good
////		goodObject.put("value", good);
////		JSONObject contentTypeObject = new JSONObject(); // contentType
////		contentTypeObject.put("value", contentType);
////		JSONObject remarkObject = new JSONObject(); // remark
////		remarkObject.put("value", remark);
////		
////		JSONObject dataObject = new JSONObject();
////		dataObject.put("first", firstObject);
////		dataObject.put("Good", goodObject);
////		dataObject.put("contentType", contentTypeObject);
////		dataObject.put("remark", remarkObject);
////		body.put("data", dataObject);
////		
////		// 发送post请求
////		String accessToken = getAccessToken();
////		logger.info("微信推送：" + remark);
////		String req = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=" + accessToken;
////		String resp = httpsRequest(req, "POST", body.toString(), "application/x-www-form-urlencoded");
////		logger.info(resp);
////		if(resp != null && JSONObject.fromObject(resp).getInt("errcode") == 0) {
////			logger.info("发送消息成功：" + remark);
////			return true;
////		}
////		return false;
////	}
//	
////	/**
////	 * 发送微信模板消息
////	 * @author luxiaopeng
////	 * @param touser 接收人
////	 * @param url 详情url
////	 * @param good 标题
////	 * @param contentType 对应状态
////	 * @param remark 内容
////	 * @param params 内容参数
////	 */
////	public static void sendTemplateMessage(String touser, String url, String good, String contentType,
////			String remark, Map<String, String> params) {
////		for(String key : params.keySet()) {
////			if(remark.contains(key))
////				remark = remark.replace(key, params.get(key));
////		}
////		sendTemplateMessage(touser, url, remark, good, contentType);
////	}
//
//	/**
//	 * 
//	 * @author luxiaopeng
//	 * @param openId
//	 * @param type 用户类型（客户：0  顾问：1）
//	 * @param params 参数（必须：pid，backType，（stageSort））
//	 * @return
//	 */
//	public static String buildTemplateUrl(String openId, Integer type, Map<String, Object> params) {
////		String url = "http://matest.mf-tal.com/maweb?openId=" + openId // 测试
////		String url = "http://stage.mf-tal.com/maweb?openId=" + openId // 正式
////				+ "&goback=message&status=0&type=" + type;
//		String url=WechatUtil.SERVERURL+"/maweb?openId=" + openId 
//				+ "&goback=message&status=0&type=" + type;
//		
//		for(String key : params.keySet()) {
//			url += "&" + key + "=" + params.get(key);
//		}
//		return url;
//	}
//	
//	/**
//	 * 通过openId获取用户基本信息
//	 * @author luxiaopeng
//	 */
//	public static JSONObject getUserInfo(String openId, String token) {
//		try {
//			return doGetJson("https://api.weixin.qq.com/cgi-bin/user/info?"
//					+ "access_token=" + token + "&openid=" + openId + "&lang=zh_CN");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//	
//	 /**
//     * 将字节数组转换为十六进制字符串.
//     * @param byteArray
//     * @return
//     */
//	private static String byteToStr(byte[] byteArray) {
//        String strDigest = "";
//        for (int i = 0; i < byteArray.length; i++) {
//            strDigest += byteToHexStr(byteArray[i]);
//        }
//        return strDigest;
//    }
//
//    /**
//     * 将字节转换为十六进制字符串.
//     * @param mByte
//     * @return
//     */
//	private static String byteToHexStr(byte mByte) {
//        char[] Digit = { '0', '1' , '2', '3', '4' , '5', '6', '7' , '8', '9', 'A' , 'B', 'C', 'D' , 'E', 'F'};
//        char[] tempArr = new char[2];
//        tempArr[0] = Digit[(mByte >>> 4) & 0X0F];
//        tempArr[1] = Digit[mByte & 0X0F];
//
//        String s = new String(tempArr);
//        return s;
//    }
//
//	
//	
//	/**
//     * 校验签名
//     * @param signature 微信加密签名.
//     * @param timestamp 时间戳.
//     * @param nonce 随机数.
//     * @return
//     */
//    public static boolean checkSignature(String signature, String timestamp, String nonce) {
//        // 对token、timestamp、和nonce按字典排序.
//        String[] paramArr = new String[] {token, timestamp, nonce};
//        Arrays.sort(paramArr);
//
//        // 将排序后的结果拼接成一个字符串.
//        String content  = paramArr[0].concat(paramArr[1]).concat(paramArr[2]);
//
//        String ciphertext = null;
//        try {
//            MessageDigest md = MessageDigest.getInstance("SHA-1");
//            // 对拼接后的字符串进行sha1加密.
//            byte[] digest = md.digest(content.toString().getBytes());
//            ciphertext = byteToStr(digest);
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        }
//
//        // 将sha1加密后的字符串与signature进行对比.
//        return ciphertext != null ? ciphertext.equals(signature.toUpperCase()) : false;
//    }
//	
//    
//    
//    public static void main(String[] args) {
////		WechatUtil.sendTemplateMessageTest("oW-tX6MBDAt3iFgbSxRt003Vh9WI", "http://www.baidu.com", "remark", "Good", "contentType", "19_8eBo5eEYuP1eOR6wjIGm2Wm3KM5-P5ttgLfMvXEoEe23HSUgywwqh8qGDJORkMB6Q9AZMUTfBBD6zHxGFBgNcR1j33OxH2X-QYySwv_-WE2FtkM-ZQtfaYyTZsqmYwmqlVZA-PdjQs3myAhJUDSjAGAHQF","Kz4oqnvhx0b-v9bbktzTfRruR1eKQvxQHyVGVgoaU1E");
//	}
//    
////    /**
////	 * 发送模板消息
////	 * @param touser 接收者openid(必填)
////	 * @param url 跳转链接(非必填)
////	 * @param msg 消息(必填)
////	 * @return
////	 * @throws IOException 
////	 */
////	public static boolean sendTemplateMessageTest(String touser, String url, String remark, String good, String contentType,String accessToken,String TEMPLATE_IDS) {
////		JSONObject body = new JSONObject();
////		body.put("touser", touser);
////		body.put("template_id", TEMPLATE_IDS);
////		if(! MyTools.isNullOrEmpty(url)) {
////			body.put("url", url);
////		}
////		JSONObject firstObject = new JSONObject(); // first
////		firstObject.put("value", "亲爱的用户，您的项目有新的进展");
////		JSONObject goodObject = new JSONObject(); // good
////		goodObject.put("value", good);
////		JSONObject contentTypeObject = new JSONObject(); // contentType
////		contentTypeObject.put("value", contentType);
////		JSONObject remarkObject = new JSONObject(); // remark
////		remarkObject.put("value", remark);
////		
////		JSONObject dataObject = new JSONObject();
////		dataObject.put("first", firstObject);
////		dataObject.put("Good", goodObject);
////		dataObject.put("contentType", contentTypeObject);
////		dataObject.put("remark", remarkObject);
////		body.put("data", dataObject);
////		
////		// 发送post请求
//////		String accessToken = getAccessToken();
//////		logger.info("微信推送：" + remark);
////		String req = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=" + accessToken;
////		String resp = httpsRequest(req, "POST", body.toString(), "application/x-www-form-urlencoded");
//////		logger.info(resp);
////		System.out.println(resp);
////		if(resp != null && JSONObject.fromObject(resp).getInt("errcode") == 0) {
////			logger.info("发送消息成功：" + remark);
////			return true;
////		}
////		return false;
////	}
//    
//    
//    //
//    private String getAccessToken(String code) {
//        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?"
//        		+ "appid="+"wx0ebd6cf96377d6f4"
//        		+ "&secret="+"96a5c964ee5157f11d5b01c57aaaecd6"
//        		+ "&code="+code
//        		+ "&grant_type=authorization_code";
//        URI uri = URI.create(url);
//        HttpClient client = new DefaultHttpClient();
//        HttpGet get = new HttpGet(uri);
//
//        HttpResponse response;
//        try {
//            response = client.execute(get);
//            if (response.getStatusLine().getStatusCode() == 200) {
//                HttpEntity entity = response.getEntity();
//
//                BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent(), "UTF-8"));
//                StringBuilder sb = new StringBuilder();
//
//                for (String temp = reader.readLine(); temp != null; temp = reader.readLine()) {
//                    sb.append(temp);
//                }
//
//                JSONObject object = new JSONObject(sb.toString().trim());
//                accessToken = object.getString("access_token");
//                openID = object.getString("openid");
//                refreshToken = object.getString("refresh_token");
//                expires_in = object.getLong("expires_in");
//                return accessToken;
//            }
//        } catch (ClientProtocolException e) {
//            // TODO Auto-generated catch block 
//            e.printStackTrace();
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (IllegalStateException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (JSONException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//
//        return null;
//    }
//    
//}                                                                                                                                                 
