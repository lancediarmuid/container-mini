package cn.noexception.test.bean.impl;

import cn.noexception.container.factory.stereotype.Cube;
import cn.noexception.test.bean.IUserService;

import java.util.Random;

/**
 * UserService
 *
 * @author 吕滔
 * @Date 2021/11/3 17:01
 */
@Cube("userService")
public class UserService implements IUserService {

    private String token;

    @Override
    public String queryUserInfo() {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "希川，100000，广州";
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
