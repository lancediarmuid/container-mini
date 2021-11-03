package cn.noexception.test.bean;

/**
 * IUserService
 *
 * @author 吕滔
 * @Date 2021/11/3 17:00
 */
public interface IUserService {
    String queryUserInfo();

    String register(String userName);
}
