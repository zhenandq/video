package com.zhiyou100.video.web.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.model.Speaker;
import com.zhiyou100.video.model.SpeakerVO;
import com.zhiyou100.video.model.video;
import com.zhiyou100.video.service.CourseService;
import com.zhiyou100.video.service.SpeakerService;
import com.zhiyou100.video.service.VideoService;
import com.zhiyou100.video.utils.Page;

@Controller
public class VideoController {
 
	@Autowired
	VideoService vs;
	@Autowired
	CourseService cs;
	@Autowired
	SpeakerService ss;
	@RequestMapping("/video/videoList.action")
	public ModelAndView VideoList(@RequestParam(value="page",required=true,defaultValue="1") Integer page,
			@RequestParam(value="videoTitle",required=true,defaultValue="") String videoTitle,
			@RequestParam(value="videoSpeaker",required=true,defaultValue="0") int videoSpeaker,
			@RequestParam(value="videoCourse",required=true,defaultValue="0") int videoCourse
			){
		SpeakerVO vo = new SpeakerVO();
		vo.setPage((page-1)*5);
		vo.setVideoCourse(videoCourse);
		vo.setVideoTitle(videoTitle);
		vo.setVideoSpeaker(videoSpeaker);
		Page<video> p = vs.loadPage(page,videoTitle,videoSpeaker,videoCourse);
		
		ModelAndView mv = new ModelAndView();		
		List<Course> listCourse = cs.findAllCourse();
		List<Speaker> listSpeaker = ss.findAllSpeaker();
		mv.addObject("speakervo", vo);
		mv.addObject("listCourse", listCourse);
		mv.addObject("listSpeaker", listSpeaker);
		mv.addObject("page", p);
		mv.setViewName("/admin/video/videoList");
		return mv;	
	}
	@RequestMapping(value="/video/addVideo.action",method=RequestMethod.GET)
	public ModelAndView addVideo01(){
		ModelAndView mv = new ModelAndView();
		List<Course> listCourse = cs.findAllCourse();
		List<Speaker> listSpeaker = ss.findAllSpeaker();
		mv.addObject("listCourse", listCourse);
		mv.addObject("listSpeaker", listSpeaker);
		mv.setViewName("/admin/video/addVideo");
		return mv;	
	}
	@RequestMapping(value="/video/addVideo.action",method=RequestMethod.POST)
	public String addVideo02(video vo){
		vs.addVideo(vo);
		return "redirect:/video/videoList.action";
	}
	@RequestMapping(value="/video/updateVideo.action",method=RequestMethod.GET)
	public ModelAndView updatevideo(int id){
		ModelAndView mv = new ModelAndView();
		List<Course> listCourse = cs.findAllCourse();
		List<Speaker> listSpeaker = ss.findAllSpeaker();
		video v = vs.findVideoById(id);
		mv.addObject("listCourse", listCourse);
		mv.addObject("listSpeaker", listSpeaker);
		mv.addObject("video", v);
		mv.setViewName("/admin/video/updateVideo");	
		return mv;
	}
	@RequestMapping(value="/video/updateVideo.action",method=RequestMethod.POST)
	public String editvideo(video v){
		vs.updateVideo(v);
		return "redirect:/video/videoList.action";
	}
	@RequestMapping("/video/deleteVideo.action")
	@ResponseBody
	public String deleteVideo(int id){
		vs.deleteVideo(id);
		return "success";	
	}
	@RequestMapping("/video/statisticsList.action")
	public ModelAndView statshow(){
		ModelAndView mv = new ModelAndView();
		List<SpeakerVO> li =  vs.findStatAvg();
		ArrayList<String> list1 = new ArrayList<>();
		ArrayList<Double> list2 = new ArrayList<>();
		for (SpeakerVO sv : li){
			if(sv.getCourseName() != null){
				list1.add(sv.getCourseName());
				list2.add(sv.getTimes());
			}
		}
		String str1 = vs.listToArray1(list1);
		String str2 = vs.listToArray2(list2);
		mv.addObject("courseName", str1);
		mv.addObject("times", str2);
		mv.setViewName("/admin/statistics/statisticsList");
		return mv;		
	}
	@RequestMapping("/video/batchDelete.action")
	public String videoBatchDelete(Integer[]checkid){
		vs.batchDelete(checkid);
		return "redirect:/video/videoList.action";
		
	}
}
