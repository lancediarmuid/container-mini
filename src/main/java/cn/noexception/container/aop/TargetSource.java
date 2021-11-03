package cn.noexception.container.aop;

/**
 * TargetSource
 *
 * @author 吕滔
 * @Date 2021/11/3 15:16
 */
public class TargetSource {

    private final Object target;

    public TargetSource(Object target){
        this.target = target;
    }

    public Class<?>[] getTargetClass(){
        return this.target.getClass().getInterfaces();
    }

    public Object getTarget(){
        return this.target;
    }

}
