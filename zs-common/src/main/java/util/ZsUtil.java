package util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import constant.Constant;
import result.vo.SortParam;

/**
 * @author Xc
 * @version 创建时间：2019年5月28日 下午5:07:49
 * @ClassName 重拾工具类
 * @Description 类描述
 */
public class ZsUtil {
	


	/**
	 * 产生一个32位的GUID
	 * 
	 * @return
	 */
	public static String getNewGUID() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString().toUpperCase();
	}

	/**
	 * 隐藏手机号中间4位
	 * @param phone
	 * @return
	 */
	public static String hidePhone(String phone){
		return phone.replaceAll("(\\d{3})\\d{4}(\\d{4})","$1****$2");
	}
	
	
	
	/**
	 * 校验手机号
	 * @param phone
	 * @return 1位数错误  2格式错误 0正确手机号
	 */
	public static int isPhone(String phone) {
	    String regex = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$";
	    if (phone.length() != 11) {
	    	//"手机号应为11位数"
	        return 1;
	    } else {
	        Pattern p = Pattern.compile(regex);
	        Matcher m = p.matcher(phone);
	        boolean isMatch = m.matches();
	        
	        if (!isMatch) {
	            //"请填入正确的手机号"
	            return 2;
	        }
	        //正确
	        return 0;
	    }
	}
	
	/**
     * 生成规则编号:字母类型+五位编号（从1开始，不够前补0）
     * 
     * @param Type            字母类型
     * @param number          自增编号
     * @return
     */
    public static String createNewNo(String type, Long number){
        String newNo = "00000000";
 
        if(type != null && number!=null){
            newNo = String.format(type + "%08d", number);
        }
 
        return newNo;
    }

    /**
     * 生成回答编号
     * 
     * @return
     */
    public synchronized static String createAnswerNo(){
		SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMddHHmmssSSS");
    	return Constant.UPPER_A+sdf.format(new Date());
    }

    /**
     * 传入前缀生成特定格式的时间编号
     * @param prefix  前缀
     * @return java.lang.String
     * @author Pan Juncai
     * @date 2019/6/26 13:52
     */
    public synchronized static String createDateNumberWithPrefix(String prefix) {
        SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMddHHmmssSSS");
        return prefix + sdf.format(new Date());
    }
	
    
   
    
    
	public static void main(String[] args) {
//		System.out.println(ZsUtil.getNewGUID());
//		System.out.println(ZsUtil.createNewNo("B",13l));
//		System.out.println(ZsUtil.createAnswerNo());
		

		
	}

	/**
	 * 计算今日话题排序值
	 * @param sortParam
	 * @return
	 */
	public static Double CalculationTodaySort(SortParam sortParam) {
		//排序值   参与回答总数*(回答查看总数*0.2+评论总数*0.3+回答点赞总数*0.5+1)/（今天时间-发布时间+1）小时*0.3
		
		Double a=sortParam.getAnswerViewCount()*0.2;
		Double b=sortParam.getCommentCount()*0.3;
		Double c=sortParam.getCommentLikeCount()*0.5;
		Long time=(System.currentTimeMillis()/1000 -sortParam.getPublishTime())/(24*60*60)+1;
		Double sort=sortParam.getAnswerCount()*((a+b+c)+1)/(time*0.3);
		return sort;
	}
	
	/**
	 * 计算回答排序值
	 * @param sortParam
	 * @return
	 */
	public static Double CalculationAnswerSort(SortParam sortParam) {
		//排序值   回答查看数*0.2+评论数*0.3+回答点赞数*0.5+1/（今天时间-发布时间+1）小时*0.3
		
		Double a=sortParam.getAnswerViewCount()*0.2;
		Double b=sortParam.getCommentCount()*0.3;
		Double c=sortParam.getAnswerLikeCount()*0.5;
		Long time=(System.currentTimeMillis()/1000 -sortParam.getPublishTime())/(24*60*60)+1;
		Double sort=((a+b+c)+1)/(time*0.3);
		return sort;
	}

	/**
	 * 判断字符串是否不为空  
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str) {
		return !ZsUtil.isEmpty(str);
	}
	
	/**
	 * 判断字符串是否为空  
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
        return str == null || str.length() == 0 ||"".equals(str.trim());
    }


	/**
	 * 返回（不低于）N位数的编号
	 *
	 * @param id 自动增长的主键
	 * @param len
	 * @return
	 */
	public static String fillSymbolToNumber(final Long id, final int len) {
		if (id == null || len > 20) {
			return null;
		}

		final String a = "9999999999999999999999";
		final String b = "0000000000000000000000";
		final String prefix = b.substring(b.length() - len, b.length());
		final int maxNumber =
				Integer.valueOf(a.substring(a.length() - len, a.length()));

		if (id > maxNumber) {
			return id + "";
		} else {
			String tr = prefix + id;
			tr = tr.substring(tr.length() - len, tr.length());
			return tr;
		}
	}
	
}
