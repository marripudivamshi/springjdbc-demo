package com.project.example.springjdbcdemo.dao;

import com.project.example.springjdbcdemo.entity.Course;

public interface SpringJdbcDAO {

	void save(Course course);

	void deleteById(long id);

	Course findById(long id);

}
