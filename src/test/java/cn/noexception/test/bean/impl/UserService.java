package cn.noexception.test.bean.impl;

import cn.noexception.test.bean.IUserService;

import java.util.Random;

/**
 * UserService
 *
 * @author 吕滔
 * @Date 2021/11/3 17:01
 */
public class UserService implements IUserService {
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
}
