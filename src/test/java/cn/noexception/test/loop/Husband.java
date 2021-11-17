package cn.noexception.test.loop;

/**
 * Husband
 *
 * @author 吕滔
 * @Date 2021/11/17 15:10
 */
public class Husband {
    private Wife wife;

    public String queryWife(){
        return "Husband.wife";
    }

    public Wife getWife() {
        return wife;
    }

    public void setWife(Wife wife) {
        this.wife = wife;
    }
}
