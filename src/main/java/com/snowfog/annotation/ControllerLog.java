package com.snowfog.annotation;

import java.lang.annotation.*;

/**
 * @author snowfog shao
 * @desc 自定义注解， 拦截controller
 * @date 17-11-25下午7:35
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ControllerLog {

    /**
     * <p>
     * 描述: 描述
     * <p/>
     * @return {@link String}
     * @author snowfog shao
     *
     */
    String desc() default "";

}