package com.zhiyou100.video.service;

import java.util.List;

import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.model.Subject;

public interface FrontCourseService {

	Subject findSubjectNameById(int subjectId);

	List<Course> findCourseBySubjectId(int subjectId);

	Course findCourse(Integer courseId);

}
