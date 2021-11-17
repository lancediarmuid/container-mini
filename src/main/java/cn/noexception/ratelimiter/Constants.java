package cn.noexception.ratelimiter;

import com.google.common.util.concurrent.RateLimiter;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Constants
 *
 * @author 吕滔
 * @Date 2021/11/16 14:47
 */
public class Constants {
    public static Map<String, RateLimiter> rateLimiterMap = Collections.synchronizedMap(new HashMap<String, RateLimiter>());
}
