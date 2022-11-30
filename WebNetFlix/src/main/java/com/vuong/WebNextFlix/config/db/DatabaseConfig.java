package com.vuong.WebNextFlix.config.db;

import java.io.IOException;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
public class DatabaseConfig {
	@Value("${db.datasource.url}")
	private String url;
	
	@Value("${db.datasource.driverClassName}")
	private String driver;
	
	@Value("${db.datasource.password}")
	private String password;
	
	@Value("${db.datasource.username}")
	private String userId;
	
	
	@Bean(name ="dataSource")
	public DataSource dataSource() {
		HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setJdbcUrl(url);
		hikariConfig.setDriverClassName(driver);
		hikariConfig.setUsername(userId);
		hikariConfig.setPassword(password);
		
		HikariDataSource hikariDataSource = new HikariDataSource(hikariConfig);
		return hikariDataSource;
	}
	/*
	 * de thuc hien cau truy vaan
	 */
	@Bean(name="transactionManager")
	DataSourceTransactionManager dataSourceTrannsactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}
	
	@Bean(name= "sqlSessionFactory")
	public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource") DataSource dataSource) throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
				.getResources("classpath:/com/vuongpham/WebNetFlix/mapper/sql/*.xml"));
		
		return sqlSessionFactoryBean.getObject();
	}
}
