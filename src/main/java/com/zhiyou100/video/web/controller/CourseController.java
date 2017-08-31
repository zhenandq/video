package com.zhiyou100.video.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.model.Subject;
import com.zhiyou100.video.service.CourseService;
import com.zhiyou100.video.service.SubjectService;
import com.zhiyou100.video.utils.Page;

@Controller
public class CourseController {

	@Autowired
	CourseService cs;
	@Autowired
	SubjectService sbs;
	@RequestMapping("/course/course.action")
	public ModelAndView CourseList(@RequestParam(value="page",required=true,defaultValue="1") Integer page){
		ModelAndView mv = new ModelAndView();
		Page<Course> p = cs.loadPage(page);
		mv.addObject("page", p);
		mv.setViewName("/admin/course/courseList");
		return mv;		
	}
	@RequestMapping(value="/course/addCourse.action",method=RequestMethod.GET)
	public ModelAndView addCourse01(){
		ModelAndView mv = new ModelAndView();
		List<Subject> listSubject = sbs.findAllSubject();
		mv.addObject("listSubject", listSubject);
		mv.setViewName("/admin/course/addCourse");
		return mv;
	}
	@RequestMapping(value="/course/addCourse.action",method=RequestMethod.POST)
	public String addCourse02(Course co){
		cs.addCourse(co);
		return "redirect:/course/course.action";
	}
	@RequestMapping(value="/course/updateCourse.action",method=RequestMethod.GET)
	public ModelAndView updateCourse01(int id){
		ModelAndView mv = new ModelAndView();
		List<Subject> listSubject = sbs.findAllSubject();
		Course co = cs.findCourseById(id); 
		mv.addObject("listSubject", listSubject);
		mv.addObject("course", co);
		mv.setViewName("/admin/course/updateCourse");
		return mv;
	}
	@RequestMapping(value="/course/updateCourse.action",method=RequestMethod.POST)
	public String editCourse(Course c){
		cs.updateCourse(c);
		System.out.println(c);
		return "redirect:/course/course.action";
	}
	@RequestMapping("/course/deleteCourse.action")
	@ResponseBody
	public String deleteCourse(int id){
		cs.deleteCourse(id);
		return "success";
		
	}
}
