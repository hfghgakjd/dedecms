package com.snowfog.config;

import java.io.IOException;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.aspectj.lang.annotation.Aspect;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.Ordered;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@PropertySource("classpath:jdbc/jdbc.properties")
@ComponentScan(basePackages = { "com.snowfog" }, excludeFilters = {
		@ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class) })
@MapperScan(basePackages = { "com.snowfog.dao" })
@EnableAspectJAutoProxy
public class GolfingAppConfig {
	private static final Logger log = LoggerFactory.getLogger(GolfingAppConfig.class);
	@Value("${jdbc.driver}")
	String driver;
	@Value("${jdbc.url}")
	String url;
	@Value("${jdbc.user}")
	String username;
	@Value("${jdbc.pwd}")
	String password;

	/**
	 * 配置数据源
	 * 
	 * @return
	 */
	@Bean(name = "dataSource")
	public DataSource dataSource() {
		BasicDataSource dbs = new BasicDataSource();
		dbs.setDriverClassName(driver);
		dbs.setUrl(url);
		dbs.setUsername(username);
		dbs.setPassword(password);
		dbs.setInitialSize(5);
		dbs.setMaxTotal(10);
		return dbs;
	}

	@Bean(name = "sqlSessionFactory")
	public SqlSessionFactoryBean sqlSessionFactory() {
		SqlSessionFactoryBean sfb = new SqlSessionFactoryBean();
		sfb.setDataSource(dataSource());
		try {
			sfb.setMapperLocations(
					new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/*.xml"));
		} catch (IOException e) {
			log.error("没有找到mybatis的映射文件:\t" + e);
			e.printStackTrace();
		}
		return sfb;
	}
}
