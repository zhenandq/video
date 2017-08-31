package com.zhiyou100.video.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhiyou100.video.model.Speaker;
import com.zhiyou100.video.model.SpeakerVO;
import com.zhiyou100.video.service.SpeakerService;
import com.zhiyou100.video.utils.Page;

@Controller
public class SpeakerController {

	@Autowired
	SpeakerService ss;
	/*@RequestMapping(value="/speaker/speaker.action",method=RequestMethod.GET)
	public ModelAndView speakerList(){
		ModelAndView mv = new ModelAndView();
		List<Speaker> list = ss.findAllSpeaker();
		mv.addObject("list",list);
		mv.setViewName("teacher/teacherList");
		return mv;	
	}*/
	@RequestMapping(value="/speaker/speaker.action",method=RequestMethod.GET)
	public ModelAndView speakerList(@RequestParam(value="page",required=true,defaultValue="1") Integer page,
			@RequestParam(value="speakerName",required=true,defaultValue="") String speakerName,
			@RequestParam(value="speakerJob",required=true,defaultValue="") String speakerJob){
				
		Page<Speaker> p = ss.loadPage(page,speakerName,speakerJob);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("speakerName", speakerName);
		mv.addObject("speakerJob", speakerJob);
		mv.addObject("page", p);
		mv.setViewName("/admin/teacher/teacherList");
		
		return mv;
		
	}
	@RequestMapping(value="/speaker/addTeacher.action",method=RequestMethod.GET)
	public String addSpeaker01(){
		return "/admin/teacher/addTeacher";	
	}
	@RequestMapping(value="/speaker/addTeacher.action",method=RequestMethod.POST)
	public String addSpeaker02(Speaker sk){
		ss.addSpeaker(sk);
		return "redirect:/speaker/speaker.action";
	}
	@RequestMapping(value="/speaker/updateSpeaker.action",method=RequestMethod.GET)
	public ModelAndView update(@RequestParam(value="id",required=true,defaultValue="1") Integer theId){
		Speaker sk = ss.findSpeakerById(theId);
		ModelAndView mv = new ModelAndView();
		mv.addObject("speaker", sk);
		mv.setViewName("/admin/teacher/updateTeacher");	
		return mv;
	}
	@RequestMapping(value="/speaker/updateSpeaker.action",method=RequestMethod.POST)
	public String editSpeaker(SpeakerVO sv){
		ss.updateSpeaker(sv.getS());
		return "redirect:/speaker/speaker.action";
	}
	@RequestMapping("/speaker/deleteSpeaker.action")
	@ResponseBody
	public String deleteSpeaker(Integer id){
		ss.deleteSpeaker(id);
		return "success";	
	}
}
