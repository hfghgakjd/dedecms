package com.dede.config;

import com.dede.auth.CustomPostProcessor;
import com.dede.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class CustomSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomPostProcessor postProcessor;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); //创建密码加密对象
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }

    /**
     * @return 封装身份认证提供者
     */
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());  //自定义的用户和角色数据提供者
//        authenticationProvider.setPasswordEncoder(passwordEncoder()); //设置密码加密对象
        return authenticationProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider()); //设置身份认证提供者
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
		        //.anonymous().disable() //关闭匿名用户
                .authorizeRequests()
                .antMatchers("/resources/**","/loginPage") //无需权限访问
		        .permitAll()
                .anyRequest().authenticated()
		        .withObjectPostProcessor(postProcessor)//这个要放到login前面才能生效
                .and()
		        .formLogin()
		        .loginPage("/loginPage")
		        .permitAll()
		        .and()
		        .logout()
		        .permitAll()
                .and().csrf().disable()
                .headers().frameOptions()
                .sameOrigin();//设置后置处理程序对象;
    }
}
