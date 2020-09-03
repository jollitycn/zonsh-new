package util;

import java.util.HashMap;
import java.util.List;
import org.slf4j.LoggerFactory;
import ch.qos.logback.classic.Logger;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisAPIUtil {

	private static final Logger logger = (Logger) LoggerFactory.getLogger(RedisAPIUtil.class);
	// 服务器IP地址
	private static final String ADDR = "182.61.132.78";
//	private static final String ADDR = "127.0.0.1";
	// 端口
	private static final int PORT = 6379;
	// 密码
	private static String AUTH = "123456";
	// 连接实例的最大连接数
	private static int MAX_ACTIVE = 10;
	// 控制一个pool最多有多少个状态为idle(空闲的)的jedis实例，默认值也是8。
	private static int MAX_IDLE = 8;
	// 等待可用连接的最大时间，单位毫秒，默认值为-1，表示永不超时。如果超过等待时间，则直接抛出JedisConnectionException
	private static int MAX_WAIT = 10000;
	// 连接超时的时间
	private static int TIMEOUT = 10000;
	// 在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
	private static boolean TEST_ON_BORROW = true;
	private static JedisPool jedisPool = null;

	/**
	 * 初始化连接池
	 */
	static {
		try {
			final JedisPoolConfig config = new JedisPoolConfig();
			config.setMaxTotal(MAX_ACTIVE);
			config.setMaxIdle(MAX_IDLE);
			config.setMaxWaitMillis(MAX_WAIT);
			config.setTestOnBorrow(TEST_ON_BORROW);

			// jedisPool = new JedisPool(config, ADDR, PORT, TIMEOUT, AUTH);
			jedisPool = new JedisPool(config, ADDR, PORT, TIMEOUT);
		} catch (final Exception e) {
			logger.error("初始化连接池失败:{}", e);
		}

	}

	/**
	 * 获取Jedis实例
	 */
	public synchronized static Jedis getJedis() {
		try {
			if (jedisPool != null) {
				final Jedis resource = jedisPool.getResource();
				return resource;
			} else {
				return null;
			}

		} catch (final Exception e) {
			logger.error(" 获取Jedis实例失败:{}", e);
			return null;
		}

	}

	/***
	 *
	 * 释放资源
	 */
	public static void returnResource(final Jedis jedis) {
		if (jedis != null) {
			jedisPool.returnResource(jedis);
		}
	}

	/**
	 *
	 * @Description: 往redis插入hash数据结构并设置过期时间
	 */
	public static void hmSetWithTime(final String key, final HashMap<String, String> paramMap, final int seconds) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			jedis.hmset(key, paramMap);
			jedis.expire(key, seconds);
		} catch (final Exception e) {
			// logger.debug("Processing trade with id: {} and symbol : {} ", id,
			// symbol);
			logger.error("往redis插入数据失败,key: {} and paramMap : {} and seconds : {}", key, paramMap, seconds, e);
		} finally {
			returnResource(jedis);
		}
	}

	/**
	 * 往redis插入hash数据结构
	 *
	 *
	 */
	public static void hmset(final String key, final HashMap<String, String> paramMap) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			jedis.hmset(key, paramMap);
		} catch (final Exception e) {
			// logger.debug("Processing trade with id: {} and symbol : {} ", id,
			// symbol);
			logger.error("往redis插入数据失败,key: {} and paramMap : {}", key, paramMap, e);
		} finally {
			returnResource(jedis);
		}
	}

	/**
	 *
	 * @Description:根据key读取redis中的hash数据
	 * @param: @param
	 *             key @param: @param fields @return: void @throws
	 */
	public static List<String> hmGet(final String key, final String... fields) {
		Jedis jedis = null;
		List<String> valueList = null;
		try {
			jedis = getJedis();
			valueList = jedis.hmget(key, fields);
		} catch (final Exception e) {
			// logger.debug("Processing trade with id: {} and symbol : {} ", id,
			// symbol);
			logger.error("读取redis数据失败,key: {} and fields : {}", key, fields, e);
		} finally {
			returnResource(jedis);
		}
		return valueList;
	}

	/**
	 *
	 * @Description: 获取key的有效时间
	 * @param: @param
	 */
	public static long getValidTime(final String key) {
		Jedis jedis = null;
		long validTime = 0l;
		try {
			jedis = getJedis();
			validTime = jedis.ttl(key);
		} catch (final Exception e) {
			// logger.debug("Processing trade with id: {} and symbol : {} ", id,
			// symbol);
			logger.error("获取redis-key有效时间失败,key: {}", key, e);
		} finally {
			returnResource(jedis);
		}
		return validTime;
	}

	/**
	 * 根据token获取uid
	 *
	 * @param token
	 * @return
	 */
	public static Integer getUidBytoken(final String token) {
		Jedis jedis = null;
		Integer value = null;
		try {
			jedis = getJedis();
			value = Integer.valueOf(jedis.get(token));
		} catch (final Exception e) {
			logger.error("获取string类型数据失败,key: {}", token, e);
		} finally {
			returnResource(jedis);
		}
		return value;
	}

	/**
	 * 设置string数据类型数据
	 *
	 * @param key
	 * @return
	 */
	public static void hSet(final String key, String value) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			value = jedis.set(key, value);
		} catch (final Exception e) {
			logger.error("设置string数据类型数据,key: {},value: {}", key, value, e);
		} finally {
			returnResource(jedis);
		}
	}

	/**
	 * 获取string数据类型数据
	 *
	 * @param token
	 * @return
	 */
	public static String hGet(final String token) {
		Jedis jedis = null;
		String value = null;
		try {
			jedis = getJedis();
			value = jedis.get(token);
		} catch (final Exception e) {
			logger.error("获取string类型数据失败,key: {}", token, e);
		} finally {
			returnResource(jedis);
		}
		return value;
	}

	/**
	 * 放入对应用户的token
	 *
	 * @param token
	 * @param uid
	 */
	public static void setTokenAndUid(final String token, final Integer uid) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			jedis.set(token, uid.toString());
		} catch (final Exception e) {
			logger.error("设置string数据类型数据,key: {},value: {}", token, uid, e);
		} finally {
			returnResource(jedis);
		}
	}

	/**
	 * 设置string数据类型数据，并设置有效时间
	 *
	 * @param key
	 * @return
	 */
	public static void hSetWithTime(final String key, String value, final int seconds) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			value = jedis.set(key, value);
			jedis.expire(key, seconds);
		} catch (final Exception e) {
			logger.error("设置string数据类型数据，并设置有效时间,key: {},value: {},seconds: {}", key, value, seconds, e);
		} finally {
			returnResource(jedis);
		}
	}

	/**
	 *
	 * @Description: 根据key删除redis中的数据 @param: @param
	 *               keys @param: @return @return: Long @throws
	 */
	public static Long hdel(final String... keys) {
		Jedis jedis = null;
		long delKeyNumber = 0l;
		try {
			jedis = getJedis();
			delKeyNumber = jedis.del(keys);
		} catch (final Exception e) {
			logger.error("根据key删除redis中的数据失败,keys: {}", keys, e);
		} finally {
			returnResource(jedis);
		}
		logger.info("根据key删除redis中的数据成功,keys: {} and delKeyNumber: {}", keys.toString(), delKeyNumber);
		return delKeyNumber;
	}

	
	/**
	 * 检查指定的key是否存在
	 * @param keys
	 * @return
	 */
	public static Boolean exists(String keys) {
		Jedis jedis = null;
		Boolean delKeyNumber = false;
		try {
			jedis = getJedis();
			delKeyNumber = jedis.exists(keys);
		} catch (final Exception e) {
			logger.error("查找指定的key是否存在失败,keys: {}", keys, e);
		} finally {
			returnResource(jedis);
		}
		return delKeyNumber;
	}
	
/*	public static void main(String[] args) {
//		RedisAPIUtil.hSet("aaa", "12312312");
		HashMap<String, String> tokenMap=new HashMap<>();
		tokenMap.put("name", "xuchao");
		tokenMap.put("sex", "1");
		RedisAPIUtil.hmset("token", tokenMap);

//		System.out.println(RedisAPIUtil.getUidBytoken("aaa"));
		System.out.println(RedisAPIUtil.hmGet("token","sex","name"));
	}*/

}
