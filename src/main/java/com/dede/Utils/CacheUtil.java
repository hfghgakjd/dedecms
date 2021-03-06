package com.dede.Utils;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.ObjectUtils;

/**
 * @author snowfog shao
 * @desc 缓存工具类
 * @date 17-11-25下午8:01
 */
public class CacheUtil {

    /**
     * <p>
     * 描述: 获取缓存中的用户
     * <p/>
     *
     * @return {@link String}
     */
    public static String getUser() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return ObjectUtils.isEmpty(userDetails)?"":userDetails.getUsername();
    }
}
