package com.zhiyou100.video.service;

import java.util.List;

import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.utils.Page;

public interface CourseService {

	List<Course> findAllCourse();

	Page<Course> loadPage(Integer page);

	void addCourse(Course co);

	Course findCourseById(int id);

	void updateCourse(Course c);

	void deleteCourse(int id);

	

}
