package user.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import result.vo.UserResult;
import user.entity.User;
import user.entity.UserThird;
import user.entity.UserToken;
import user.mapper.UserMapper;
import user.mapper.UserThirdMapper;
import user.mapper.UserTokenMapper;
import user.service.IUserThirdService;
import util.TimeToolUtil;
import util.ZsUtil;
import util.jwt.JwtHelper;

/**
 * <p>
 * 第三方登录表 服务实现类
 * </p>
 *
 * @author xc
 * @since 2019-05-28
 */
@Service
public class UserThirdServiceImpl extends ServiceImpl<UserThirdMapper, UserThird> implements IUserThirdService {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private UserTokenMapper userTokenMapper;

	@Override
	public UserResult wxLogin(final String code) {
		// 定义返回
		final UserResult result = new UserResult();

		// 操作时间
		final Date crateTime = new Date();

		// 根据微信授权码code获取微信登录凭证
		final String url = "https://api.weixin.qq.com/sns/oauth2/access_token?"
		+ "appid=wx0ebd6cf96377d6f4"
		+ "&secret=96a5c964ee5157f11d5b01c57aaaecd6"
		+ "&code=" + code
		+ "&grant_type=authorization_code";
		final URI uri = URI.create(url);
		final HttpClient client = new DefaultHttpClient();
		final HttpGet get = new HttpGet(uri);
		HttpResponse response;
		try {
			response = client.execute(get);
			if (response.getStatusLine().getStatusCode() == 200) {
				final HttpEntity entity = response.getEntity();

				final BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent(), "UTF-8"));
				final StringBuilder sb = new StringBuilder();

				for (String temp = reader.readLine(); temp != null; temp = reader.readLine()) {
					sb.append(temp);
				}

				final JSONObject object = new JSONObject(sb.toString().trim());
				System.out.println(sb.toString());
				final String accessToken = object.getString("access_token");
				final String openid = object.getString("openid");
				final String refreshToken = object.getString("refresh_token");
				final String unionid = object.getString("unionid");
				final Long expiresIn = object.getLong("expires_in");




				// 根据openid查询该用户是否存在
				final UserThird entityParam = new UserThird();
				entityParam.setThirdKey(openid);
				final UserThird query = baseMapper.selectOne(entityParam);

				// 如果为空，说明该用户是第一次登录，则需要获取该用户的微信信息，并且写入用户数据
				if (query == null) {
					// 查询用户微信信息
					final HashMap<String, String> userInfo = this.getUserInfo(accessToken, openid, expiresIn);
					final String wxName = userInfo.get("nickname");
					final Integer sex = Integer.valueOf(userInfo.get("sex"));

					// 新建用户记录
					final User userInsert = new User();
					userInsert.setCreateTime(crateTime);
					userInsert.setUname(wxName);
					userInsert.setWxName(wxName);
					userInsert.setHeadurl(userInfo.get("headimgurl"));
					userInsert.setGender(sex);
					userInsert.setStatus(0);
					userMapper.insert(userInsert);

					// 新建token记录
//					final UserToken token = new UserToken();
//					token.setUid(userInsert.getUid());
//					token.setLoginTime(crateTime);
//					final String tokenStr = ZsUtil.getNewGUID();
//					token.setTokenContent(tokenStr);
//					userTokenMapper.insert(token);
					
					 //使用新的jwtToken 不存放token到数据库
		            Map<String, String> claims = new HashMap<>();
		            claims.put("uid", userInsert.getUid().toString());
		            claims.put("uName", wxName);
		            claims.put("loginTime", TimeToolUtil.parseDateToString(crateTime, TimeToolUtil.DATEFORMAT_Y4_MM_DD_HMS));
		            String jwtToken=JwtHelper.genToken(claims);

					// 新建第三方信息记录
					final UserThird inseryThird=new UserThird();
					inseryThird.setCreateTime(crateTime);
					inseryThird.setThirdKey(openid);
					inseryThird.setThirdKeyAll(unionid);
					inseryThird.setThirdType("WECHAT");
					inseryThird.setUid(userInsert.getUid());
					inseryThird.setAccessToken(accessToken);
					inseryThird.setRefreshToken(refreshToken);
					inseryThird.setExpiresIn(expiresIn);
					baseMapper.insert(inseryThird);

					// 写入返回信息
					result.setIsRegister(1);
//					result.setUToken(tokenStr);
					result.setUToken(jwtToken);
					result.setUname(wxName);
					result.setGender(sex);
					result.setStatus(0);
					result.setUid(userInsert.getUid());
				} else {
					// 查询该用户
					final User user = userMapper.selectById(query.getUid());

					//标识该用户被冻结，不允许登录
					if(user.getStatus()==2){
						result.setStatus(2);
						return result;
					}

					// 更新登录信息
//					final UserToken queryToken = new UserToken();
//					queryToken.setUid(query.getUid());
//					final UserToken queryInfo = userTokenMapper.selectOne(queryToken);
//					queryInfo.setLoginTime(new Date());
//					queryInfo.setStatus(1);
//					userTokenMapper.updateById(queryInfo);
					
					//使用新的jwtToken 不存放token到数据库
		            Map<String, String> claims = new HashMap<>();
		            claims.put("uid", query.getUid().toString());
		            claims.put("uName", user.getUname());
		            claims.put("loginTime", TimeToolUtil.parseDateToString(crateTime, TimeToolUtil.DATEFORMAT_Y4_MM_DD_HMS));
		            String jwtToken=JwtHelper.genToken(claims);
					
					

					result.setIsRegister(0);
//					result.setUToken(queryInfo.getTokenContent());
					result.setUToken(jwtToken);
					result.setUname(user.getUname());
					result.setGender(user.getGender());
					result.setHeadUrl(user.getHeadurl() == null ? null : user.getHeadurl());
					result.setStatus(user.getStatus());
					result.setUid(query.getUid());
				}

				return result;

			}

		} catch (final ClientProtocolException e) {
			e.printStackTrace();
		} catch (final IOException e) {
			e.printStackTrace();

		} catch (final IllegalStateException e) {
			e.printStackTrace();
		} catch (final JSONException e) {
			e.printStackTrace();
		}

		return null;
	}

	private HashMap<String, String> getUserInfo(final String accessToken, final String openid, final Long expires_in) {
//		if (isAccessTokenIsInvalid(accessToken, openid) && System.currentTimeMillis() < expires_in) {
			final String uri = "https://api.weixin.qq.com/sns/userinfo?access_token=" + accessToken + "&openid=" + openid;
			final HttpClient client = new DefaultHttpClient();
			final HttpGet get = new HttpGet(URI.create(uri));
			try {
				final HttpResponse response = client.execute(get);
				if (response.getStatusLine().getStatusCode() == 200) {
					final BufferedReader reader = new BufferedReader(
							new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
					final StringBuilder builder = new StringBuilder();
					for (String temp = reader.readLine(); temp != null; temp = reader.readLine()) {
						builder.append(temp);
					}
					final JSONObject object = new JSONObject(builder.toString().trim());
					final String nickname = object.getString("nickname");
					final Integer sex = object.getInt("sex");
					final String headimgurl = object.getString("headimgurl");
					final HashMap<String, String> result = new HashMap<>();
					result.put("nickname", nickname);
					result.put("sex", sex.toString());
					result.put("headimgurl", headimgurl);
					return result;
				}

			} catch (final ClientProtocolException e) {
				e.printStackTrace();
			} catch (final IOException e) {
				// TODO Auto-generated catch block
			} catch (final JSONException e) {
				e.printStackTrace();
			}

		return null;
	}

	private boolean isAccessTokenIsInvalid(final String accessToken, final String openID) {
		final String url = "https://api.weixin.qq.com/sns/auth?access_token=" + accessToken + "&openid=" + openID;
		final URI uri = URI.create(url);
		final HttpClient client = new DefaultHttpClient();
		final HttpGet get = new HttpGet(uri);
		HttpResponse response;
		try {
			response = client.execute(get);
			if (response.getStatusLine().getStatusCode() == 200) {
				final HttpEntity entity = response.getEntity();

				final BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent(), "UTF-8"));
				final StringBuilder sb = new StringBuilder();

				for (String temp = reader.readLine(); temp != null; temp = reader.readLine()) {
					sb.append(temp);
				}
				final JSONObject object = new JSONObject(sb.toString().trim());
				final int errorCode = object.getInt("errcode");
				if (errorCode == 0) {
					return true;
				}
			}
		} catch (final ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (final IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (final JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}


}
