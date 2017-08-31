package com.zhiyou100.video.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.video.mapper.CourseMapper;
import com.zhiyou100.video.mapper.SubjectMapper;
import com.zhiyou100.video.mapper.videoMapper;
import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.model.CourseExample;
import com.zhiyou100.video.model.Subject;
import com.zhiyou100.video.model.video;
import com.zhiyou100.video.model.videoExample;
import com.zhiyou100.video.service.FrontCourseService;
@Service
public class FrontCourseServiceImpl implements FrontCourseService {

	@Autowired
	SubjectMapper sm;
	@Autowired
	CourseMapper cm;
	@Autowired
	videoMapper vm;
	@Override
	public Subject findSubjectNameById(int subjectId) {
		Subject subject = sm.selectByPrimaryKey(subjectId);
		return subject;
	}

	@Override
	public List<Course> findCourseBySubjectId(int subjectId) {
		CourseExample example = new CourseExample();
		example.createCriteria().andSubjectIdEqualTo(subjectId);
		List<Course> cour = cm.selectByExample(example);
		List<Course> course = new ArrayList<>();
		for (Course course2 : cour){
			videoExample exa = new videoExample();
			exa.createCriteria().andCourseIdEqualTo(course2.getId());
			List<video> exam = vm.selectByExample(exa);
			course2.setVideoList(exam);
			course.add(course2);
		}
		return course;
	}

	@Override
	public Course findCourse(Integer courseId) {
		return cm.selectByPrimaryKey(courseId);
	}

	
}
