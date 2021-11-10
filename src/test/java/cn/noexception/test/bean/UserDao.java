package cn.noexception.test.bean;

import cn.noexception.container.factory.stereotype.Cube;

import java.util.HashMap;
import java.util.Map;

/**
 * UserDao
 *
 * @author 吕滔
 * @Date 2021/11/9 13:37
 */
@Cube
public class UserDao {
    private static Map<String, String> hashMap = new HashMap<>();

    static {
        hashMap.put("10001", "山鸡，香港， 旺角");
        hashMap.put("10002", "陈浩南，香港， 尖沙咀");
        hashMap.put("10003", "大头菜，香港， 旺角");
        hashMap.put("10004", "肥嗨，香港， 旺角");
    }
    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }
}
