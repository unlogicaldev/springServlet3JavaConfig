package com.servlet3.sample.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
//@MapperScan("classpath:com/servlet3/sample/model/mapper/**/*.xml")
public class MybatisConfig {
		
	@Bean
	@Autowired
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{
		SqlSessionFactoryBean sb = new SqlSessionFactoryBean();
		sb.setDataSource(dataSource);
		sb.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:com/servlet3/sample/model/mapper/*.xml"));
		sb.setConfigLocation(new DefaultResourceLoader().getResource("classpath:config_mybatis.xml"));
		return sb.getObject();
	}

	@Bean
	@Autowired
	public SqlSessionTemplate sqlSession(SqlSessionFactory sqlSessionFactory){
		SqlSessionTemplate s = new SqlSessionTemplate(sqlSessionFactory);
		return s;
	}
}
