package com.project.example.springjdbcdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.project.example.springjdbcdemo.dao.SpringJdbcDAO;
import com.project.example.springjdbcdemo.entity.Course;

@SpringBootApplication
public class SpringJdbcDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcDemoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(SpringJdbcDAO springJdbcDao) { 
		return runner -> {
			createCourse(springJdbcDao);
		};
	}

	private void createCourse(SpringJdbcDAO springJdbcDao) {
		Course course1 = new Course(1, "AWS", "RAMASWAMY");
		Course course2 = new Course(2, "AWS", "RAMASWAMY");
		Course course3 = new Course(3, "AWS", "RAMASWAMY");
		springJdbcDao.save(course1);
		springJdbcDao.save(course2);
		springJdbcDao.save(course3);
		System.out.println("save completed");
		
		springJdbcDao.deleteById(1);
		System.out.println("user 8 deleted");
		
		springJdbcDao.findById(2);
		springJdbcDao.findById(3);
		System.out.println("user 9,10 found");
		 
		
	}

}
