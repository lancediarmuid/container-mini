package cn.noexception.test.bean;

import cn.noexception.container.factory.annotation.Inject;
import cn.noexception.container.factory.annotation.InputValue;
import cn.noexception.container.factory.stereotype.Cube;

import java.util.Random;

/**
 * UserService
 *
 * @author 吕滔
 * @Date 2021/11/3 17:01
 */
@Cube("userService")
public class UserService implements IUserService {

    @InputValue("${token}")
    private String token;

    @Inject
    private UserDao userDao;

    @Override
    public String queryUserInfo() {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return userDao.queryUserName("10001") + ", " + token;
    }

    @Override
    public String register(String userName) {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "注册用户：" + userName + " success! ";
    }

    @Override
    public String toString() {
        return "UserService#token = { " + token + " }";
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
