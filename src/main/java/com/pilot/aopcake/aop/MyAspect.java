package com.pilot.aopcake.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

@Aspect
@Component
public class MyAspect {

    private Logger logger = LoggerFactory.getLogger("Cake aop");

    @Pointcut("execution(* com.pilot.aopcake.service.CakeCreationService.*(..))")
    public void cut() {}

    /*这段代码是一个切入点(Pointcut)定义，用于在AOP（面向切面编程）中选择要拦截的目标方法。具体解释如下：

        @Pointcut("execution(* com.pilot.aopcake.service.CakeCreationService.*(..))"): 这是一个切入点注解，指定了切入点表达式。切入点表达式描述了要拦截的方法的匹配规则。
        execution(...): 这是切入点表达式的一部分，表示要匹配的方法的执行。execution是最常用的切入点指示符之一。
        *: 通配符，表示匹配任意的返回类型。
        com.pilot.aopcake.service.CakeCreationService: 表示要匹配的目标类的全限定名。
        *: 通配符，表示匹配目标类中的任意方法名。
        (..): 表示匹配任意参数的方法。
        综上所述，这段代码的切入点定义意味着匹配com.pilot.aopcake.service.CakeCreationService类中的所有方法，无论方法名和参数如何。在AOP中，当这些匹配的方法被调用时，可以通过切面（Aspect）来拦截和执行额外的逻辑。

    */


    @Before("cut()")
    public void bakeCakeBase(JoinPoint joinPoint) {
        logger.info("Begin to bake cake base ");

        Signature signature = joinPoint.getSignature();
        logger.info("Signature name is " + signature.getName() + ". ");

        for (Object object: joinPoint.getArgs()) {
            logger.info("Print out from MyAspect " + object.toString());
        }
    }

    @After("cut()")
    public void addTopping(JoinPoint joinPoint) {
        logger.info("Adding Strawberry Toppings.");
        logger.info("The New Cake has been all set.");
    }
}
