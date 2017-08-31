package com.zhiyou100.video.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.model.Subject;
import com.zhiyou100.video.service.CourseService;
import com.zhiyou100.video.service.FrontCourseService;
import com.zhiyou100.video.service.VideoService;

@Controller
public class FrontCourse {

	@Autowired
	CourseService cs;
	@Autowired
	VideoService vs;
	@Autowired
	FrontCourseService fcs;
	@RequestMapping("front/course/index.action")
	public String courseIndex(int subjectId,Model mo){
		Subject sub = fcs.findSubjectNameById(subjectId);
		List<Course> list = fcs.findCourseBySubjectId(subjectId);
		for (Course course : list){
			course.setVideoList(vs.findVideoByCourseId(course.getId()));
		}
		mo.addAttribute("subjectId", subjectId);
		mo.addAttribute("courses", list);
		mo.addAttribute("subject", sub);
		return "/front/course/index";		
	}
	
}
