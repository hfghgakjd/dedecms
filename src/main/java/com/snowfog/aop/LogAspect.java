package com.snowfog.aop;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.snowfog.Utils.CacheUtil;
import com.snowfog.annotation.ControllerLog;

/**
 * @author snowfog shao
 * @desc 切点类
 * @date 17-11-25下午7:50
 */
@Aspect
@Component
public class LogAspect {

    //记录本地异常
    private final Logger logger = LoggerFactory.getLogger(LogAspect.class);


    /**
     * <p>
     * 描述: controller 切点
     * <p/>
     *
     * @author snowfog shao
     */
    @Pointcut("@annotation(com.snowfog.annotation.ControllerLog)")
    public void controllerAspcet() {
    }


    /**
     * <p>
     * 描述: 前置通知, 拦截Controller用户记录操作
     * <p/>
     *
     * @param joinPoint 切点
     * @author snowfog shao
     */
    @Before("controllerAspcet()")
    public void doBefore(JoinPoint joinPoint) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();
        //获取用户信息
        String username = CacheUtil.getUser();
        //请求ip
        String ip = request.getRemoteAddr();

        try{
            System.out.println("请求方法:\t" + (joinPoint.getTarget().getClass().getName()));
            System.out.println("方法描述:\t" + getControllerMethodDescription(joinPoint));
            System.out.println("用户:\t" + username);
            System.out.println("访问ip:\t" + ip);
        }catch(Exception e){
            logger.error("记录controller日志时发生错误!",e);
        }
    }

    /**
     * <p>
     * 描述: 获取controller方法描述
     * <p/>
     * @param joinPoint
     * @author snowfog shao
     * @return {@link String}
     */
    private String getControllerMethodDescription(JoinPoint joinPoint)throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class<?> targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String description = "";
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class<?>[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    description = method.getAnnotation(ControllerLog.class).desc();
                    break;
                }
            }
        }
        return description;
    }
}
