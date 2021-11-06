package cn.noexception.container.aop.aspectj;

import cn.noexception.container.aop.Pointcut;
import cn.noexception.container.aop.PointcutAdvisor;
import org.aopalliance.aop.Advice;

/**
 * AspectJExpressionPointcutAdvisor
 * <p>
 *     实现了 PointcutAdvisor 接口，把切面、拦截方法和具体拦截表达式包装在一起。</br>
 *     这样就可以在 xml 的配置中定义一个 pointcutAdvisor 切面拦截器了。
 * </p>
 *
 * @author 吕滔
 * @Date 2021/11/4 16:30
 */
public class AspectJExpressionPointcutAdvisor implements PointcutAdvisor {
    // 切面
    private AspectJExpressionPointcut pointcut;
    // 具体的拦截方法
    private Advice advice;
    // 表达式
    private String expression;

    public String getExpression() {
        return expression;
    }

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }

    @Override
    public Advice getAdvice() {
        return advice;
    }

    @Override
    public Pointcut getPointcut() {
        if (null == pointcut) {
            pointcut = new AspectJExpressionPointcut(expression);
        }
        return pointcut;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }
}
