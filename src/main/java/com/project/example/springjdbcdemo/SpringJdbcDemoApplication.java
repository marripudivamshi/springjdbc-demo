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
		Course course1 = new Course(1, "AWS", "Ramaswamy");
		Course course2 = new Course(2, "Azure", "Rambo");
		Course course3 = new Course(3, "GCP", "Milano");
		springJdbcDao.save(course1);
		springJdbcDao.save(course2);
		springJdbcDao.save(course3);
		System.out.println("save completed");
		
		springJdbcDao.deleteById(2);
		System.out.println("user 1 deleted");
		
		springJdbcDao.findById(1);
		springJdbcDao.findById(3);
		System.out.println("user 1,3 found");
		 
		
	}

}
