package cn.noexception.test.loop;

/**
 * Wife
 *
 * @author 吕滔
 * @Date 2021/11/17 15:10
 */
public class Wife {
    private Husband husband;
    private IMother mother;

    public String queryHusband(){
        return "Wife.husband、Mother.callMother: "+mother.callMother();
    }

    public Husband getHusband() {
        return husband;
    }

    public void setHusband(Husband husband) {
        this.husband = husband;
    }

    public IMother getMother() {
        return mother;
    }

    public void setMother(IMother mother) {
        this.mother = mother;
    }
}
