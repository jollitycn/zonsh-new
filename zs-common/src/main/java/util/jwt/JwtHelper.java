package util.jwt;

import java.io.UnsupportedEncodingException;
import java.security.KeyPair;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.google.common.base.Strings;
import org.apache.commons.lang3.time.DateUtils;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.google.common.collect.Maps;

import constant.Constant;

public class JwtHelper {

	 //设置发行人
    private static final String ISSUER = "ZonshJWTServer";

    public static String genToken(Map<String, String> claims){
        try {
        //这里的JwtRsaUtil是自定义的另一个工具类，用于从jks证书文件中提取公钥和私钥，进行RSA加密解密
//            JwtRsaUtil jwtRsaUtil = new JwtRsaUtil("/*****.jks", "*****".toCharArray());
//            //获取秘钥对
//            KeyPair keyPair = jwtRsaUtil.getKeyPair();
//            //然后就是设置加密算法了，可以选择许多不同的加密算法，这里使用的RSA256非对称加密，安全性更好。如果为了方便，也可以使用HS256对称加密
//            Algorithm algorithm = Algorithm.RSA256((RSAPublicKey) keyPair.getPublic(), (RSAPrivateKey) keyPair.getPrivate());
        	
        	//这里使用HMAC512算法
            Algorithm algorithm=Algorithm.HMAC512(Constant.JWT_SECRET);
            //开始构建JWT，这里可以设置很多信息，我只设置了发行人和过期时间
            JWTCreator.Builder builder = JWT.create().withIssuer(ISSUER).withExpiresAt(DateUtils.addDays(new Date(), 1));
            //然后把传入的claims放进builder里面，这里使用了java8的方法引用，也可以说是lambda的简化写法吧，本来写的lambda表达式，然后提示这里还可以简化，然后就变成这样子了。。
            claims.forEach(builder::withClaim);
            //签名之后返回
            return builder.sign(algorithm);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
    }
    //验签并返回解析数据
    public static Map<String, String> verifyToken(String token) throws UnsupportedEncodingException  {
      if(!Strings.isNullOrEmpty(token)&&!"null".equals(token)) {
          Algorithm algorithm = null;
          try {
//            KeyPair keyPair = JwtRsaUtil.getInstance().getKeyPair();
//            algorithm = Algorithm.RSA256((RSAPublicKey) keyPair.getPublic(), (RSAPrivateKey) keyPair.getPrivate());
              algorithm = Algorithm.HMAC512(Constant.JWT_SECRET);
          } catch (IllegalArgumentException e) {
              throw new RuntimeException(e);
          }
          JWTVerifier verifier = JWT.require(algorithm).withIssuer(ISSUER).build();
          DecodedJWT jwt = verifier.verify(token);
          Map<String, Claim> map = jwt.getClaims();
          Map<String, String> resultMap = Maps.newHashMap();
          map.forEach((k, v) -> resultMap.put(k, v.asString()));
          return resultMap;
      }
      return null;
    }
	
   
    
    public static void main(String[] args) throws UnsupportedEncodingException {
		
    	 // 生成JWT
        Map<String, String> claims = new HashMap<>();
        claims.put("uid", 33+"");
        claims.put("nickName", "许超");
        claims.put("login_method", "POST");
        claims.put("openId", "952asdasdsadassada7");
        claims.put("ts", Instant.now().getEpochSecond()+"");
        String jwtToken = JwtHelper.genToken(claims);
    	
    	System.out.println("jwtToken="+jwtToken);
    	
//    	String aa="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJuaWNrTmFtZSI6IuiuuOi2hSIsIm9wZW5JZCI6Ijk1MjciLCJsb2dpbl9tZXRob2QiOiJQT1NUIiwiaXNzIjoidXNlciIsImlkIjoiMzMiLCJleHAiOjE1NjQ0NTMwMDIsInRzIjoiMTU2NDM2NjYwMiJ9.Gu_YU7H_RVPBw1tV8z7q6PDhoJ7yGwnE3ph5VZI7cG83-5eWq_OQXew94uNe0t7kS52-UxWAxRt44aGg1kO52A";
    	System.out.println(jwtToken.length());
    	Map<String, String> map=JwtHelper.verifyToken(jwtToken);
    	System.out.println(map.toString());
    }
    
}
