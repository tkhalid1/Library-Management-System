package com.library;


import com.library.management.dao.BookDao;
import com.library.management.dao.CategoryDao;
import com.library.management.dao.UserDao;
import com.library.management.dao.impl.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

@Configuration
@ComponentScan("com.library.management")
public class AppConfig {


	@Value("${database.format}")
	private String databaseFormat;


	@Bean
	public UserDao userDao(){
		if(false == StringUtils.isEmpty(databaseFormat)){
			if(databaseFormat.equals("yml")){
				return new UserDaoYmlImpl();
			} else{
				return new UserDaoJsonImpl();
			}
		}
		return new UserDaoJsonImpl();
	}

	@Bean
	public BookDao bookDao(){
		if(false == StringUtils.isEmpty(databaseFormat)){
			if(databaseFormat.equals("yml")){
				return new BookDaoYmlImpl();
			} else{
				return new BookDaoYmlImpl();
			}
		}
		return new BookDaoJsonImpl();
	}

	@Bean
	public CategoryDao categoryDao(){
		if(false == StringUtils.isEmpty(databaseFormat)){
			if(databaseFormat.equals("yml")){
				return new CategoryDaoYmlImpl();
			} else {
				return new CategoryDaoYmlImpl();
			}

		}
		return new CategoryDaoJsonImpl();
	}

}
