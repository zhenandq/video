package com.zhiyou100.video.service.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.video.mapper.CourseMapper;
import com.zhiyou100.video.mapper.SubjectMapper;
import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.service.CourseService;
import com.zhiyou100.video.utils.Page;
@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseMapper cm;
	@Autowired
	SubjectMapper sbm;
	@Override
	public List<Course> findAllCourse() {
		return cm.selectByExample(null);
	}
	@Override
	public Page<Course> loadPage(Integer page) {
		Page<Course> p = new Page<>();
		p.setPage(page);
		p.setSize(5);
		p.setRows(cm.findCourseByPage((page-1)*5));
		p.setTotal(cm.countCourse(page));
		return p;
	}
	@Override
	public void addCourse(Course co) {
		co.setInsertTime(new Timestamp(System.currentTimeMillis()));
		cm.insertSelective(co);
	}
	@Override
	public Course findCourseById(int id) {
		return cm.selectByPrimaryKey(id);
	}
	@Override
	public void updateCourse(Course c) {

		cm.updateByPrimaryKeySelective(c);
		
	}
	@Override
	public void deleteCourse(int id) {

		cm.deleteByPrimaryKey(id);
	}
	
}
