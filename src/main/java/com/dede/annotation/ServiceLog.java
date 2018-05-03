package com.dede.annotation;

import java.lang.annotation.*;

/**
 * @author snowfog shao
 * @desc 自定义注解， 拦截Service
 * @date 17-11-25下午7:46
 */
@Target({ElementType.PARAMETER,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ServiceLog{

    /**
     * <p>
     * 描述: 描述
     * <p/>
     * @author snowfog shao
     * @return {@link String}
     */
    String desc() default "";
}
