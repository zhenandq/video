package com.zhiyou100.video.web.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.model.Speaker;
import com.zhiyou100.video.model.Subject;
import com.zhiyou100.video.model.video;
import com.zhiyou100.video.service.FrontCourseService;
import com.zhiyou100.video.service.FrontSpeakerService;
import com.zhiyou100.video.service.FrontVideoService;


@Controller
public class FrontVideoController {

	@Autowired
	FrontCourseService fcs;
	@Autowired
	FrontSpeakerService fss;
	@Autowired
	FrontVideoService fvs;
	@RequestMapping("front/video/index.action")
	public String courseIndex(int subjectId,int videoId,Model mo){
		Subject sub = fcs.findSubjectNameById(subjectId);
		mo.addAttribute("subject", sub);
		mo.addAttribute("videoId", videoId);
		return "/front/video/index";		
	}
	@RequestMapping("front/video/videoData.action")
	public String videoData(Integer videoId,Model mo){
		
		mo.addAttribute("videoId", videoId);
		video v = fvs.findAllVideo(videoId);
		mo.addAttribute("video", v);
		Speaker sp = fss.findSpeaker(v.getSpeakerId());
		mo.addAttribute("speaker", sp);
		Course co = fcs.findCourse(v.getCourseId());
		mo.addAttribute("course", co);
		List<video> list = fvs.findAllvideo(co.getId());
		mo.addAttribute("videoList", list);
		return "/front/video/content";		
	}
	@RequestMapping("front/video/state.action")
	public void state(Integer videoId){
		video v = fvs.findAllVideos(videoId);
		Integer times = v.getVideoPlayTimes()+1;
		v.setVideoPlayTimes(times);
		fvs.updateVideo(v);
		System.out.println(times);
	}
}
