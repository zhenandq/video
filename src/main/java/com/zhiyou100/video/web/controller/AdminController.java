package com.zhiyou100.video.web.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zhiyou100.video.model.Admin;
import com.zhiyou100.video.service.AdminService;

@Controller
public class AdminController {
	@Autowired
	AdminService as;	
	
	@RequestMapping(value="/adminLogin.action",method=RequestMethod.GET)
	public String login(){
		return "/admin/index";
	}

	@RequestMapping(value="/adminLogin.action",method=RequestMethod.POST)
	public String login(Admin admin,Model md,HttpSession session){
		
		List<Admin>  list = as.findAdminByNameAndPwd(admin);
		if(list.isEmpty()){
			md.addAttribute("errorMessage", "用户名密码不匹配");
			return "forward:/WEB-INF/view/admin/index.jsp";
		}
		session.setAttribute("admin", list.get(0));
		return "redirect:/video/videoList.action";
	}
}
