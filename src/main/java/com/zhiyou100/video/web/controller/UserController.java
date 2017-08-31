package com.zhiyou100.video.web.controller;


import java.io.File;
import java.util.Random;
import java.util.UUID;

import javax.mail.Session;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.zhiyou100.video.model.Result;
import com.zhiyou100.video.model.User;
import com.zhiyou100.video.service.UserService;
import com.zhiyou100.video.utils.MD5Utils;
import com.zhiyou100.video.utils.MailUtil;

@Controller
public class UserController {

	@Autowired
	UserService us;
    @RequestMapping("/front/user/out.action")
	public String Login(HttpSession session){ 
    	session.invalidate();
		return "redirect:/index.jsp";		
	}
	//登录
	@RequestMapping("/front/user/login.action")
	@ResponseBody
	public Result userLogin(User user,HttpSession session){		
		User u = us.findUserByEmailAndPwd(user);
		Result re = new Result();
		if(u != null){
			re.setSuccess(true);
			session.setAttribute("_front_user", u);
		}else{
			re.setMessage("登录失败");
		}
		return re;		
	}
	//跳转index.jsp界面
	@RequestMapping("/front/user/index.action")
	public String index(Integer id,Model md){
		md.addAttribute("user", us.findUserById(id));
		return "front/user/index";		
	}
	//修改资料
	@RequestMapping(value="/front/user/profile.action",method=RequestMethod.GET )
	public String profile01(Integer id,Model md){
		User u = us.findUserById(id);
		md.addAttribute("user", u);		
		return "front/user/profile";		
	}
	@RequestMapping(value="/front/user/profile.action",method=RequestMethod.POST )
	public String profile02(User u){
		int a = u.getId();
		us.updateUser(u);	
		System.out.println(u);
		return "redirect:/front/user/index.action?id="+a;		
	}
	//修改头像
	@RequestMapping(value="/front/user/avatar.action",method=RequestMethod.GET )
	public String avatar01(Integer id,Model md){
		User u = us.findUserById(id);
		md.addAttribute("user", u);		
		return "front/user/avatar";		
	}
	@RequestMapping(value="/front/user/avatar.action",method=RequestMethod.POST)
	public String editRole(User u,MultipartFile image_file,HttpSession session,Model md) throws Exception{
		int a = u.getId();
		String str = UUID.randomUUID().toString().replaceAll("-","");
		String ext = FilenameUtils.getExtension(image_file.getOriginalFilename());
		String fileName = str+"."+ext;
		String path = "D:\\upload";
		image_file.transferTo(new File(path+"\\"+fileName));
		//u.setHeadUrl(fileName);
		u.setHeadUrl(fileName);
		us.updateAvatar(u);
		User user = us.findUserById(u.getId());
		session.setAttribute("_front_user", user);
		return "redirect:/front/user/index.action?id="+a;
	}
	//修改密码
	@RequestMapping(value="/front/user/password.action",method=RequestMethod.GET )
	public String password01(Integer id,Model md){
		User u = us.findUserById(id);
		md.addAttribute("user", u);		
		return "front/user/password";		
	}
	@RequestMapping(value="/front/user/password.action",method=RequestMethod.POST )
	public String password02(Integer id,Model md,String oldPassword,String newPassword){
		User u = us.findUserById(id);
		String str = null;
		String old = MD5Utils.getMD5(oldPassword);
	    old = MD5Utils.getMD5(old);	
		if(old.equals(u.getPassword())){
			u.setPassword(newPassword);
			str="修改成功";
			md.addAttribute("message", str);
			us.updatePwd(u);
		}else{
			str="修改失败";
			md.addAttribute("message", str);
		}
		md.addAttribute("user", u);		
		return "front/user/password";		
	}
	@RequestMapping(value="/front/user/forget_pwd.action",method=RequestMethod.GET )
	public String sendEmail01(){			
		return "front/user/forget_pwd";		
	}
	@RequestMapping("/front/user/sendEmail.action")
	@ResponseBody
	public Result sendEmail02(String email) throws Exception{		
		Random ran = new Random();
		String a = ""+(ran.nextInt(99999-10000+1)+10000);
	
		User u = us.findUserByEmail(email);
		Result re = new Result();
		if(u != null){
			re.setSuccess(true);
		    MailUtil.send(email, "验证码", a);
		    u.setCaptcha(a);
		    us.updateCaptcha(u);
		}else{
			re.setMessage("邮箱不存在,请确认或去注册");
		}
		return re;		 
	}
	@RequestMapping(value="/front/user/resetPwd.action",method=RequestMethod.GET )
	public String resetPwd01(User user,Model mo){		
		User u = us.findUserByCaptcha(user);
		if(u != null){
			mo.addAttribute("user", user);
		}else{
			mo.addAttribute("errorMessage", "验证码输入错误,请重新获取");
			return "front/user/forget_pwd";
		}
		return "front/user/reset_pwd";				
	}
	@RequestMapping(value="/front/user/resetPwd.action",method=RequestMethod.POST )
	public String resetPwd02(User u,String password){	
		//String a = u.getEmail();
		//User u = new User();
		User user = us.findUserByCaptcha(u);
		user.setPassword(password);
		us.updatePwd(user);
		User user1 = us.findUserByCaptcha(u);
		System.out.println(user1);
		return "redirect:/index.jsp";				
	}
	//注册
	@RequestMapping("/front/user/regist.action")
	@ResponseBody
	public Result userRegist(User user,HttpSession session){		
		User u = us.findUserByEmail(user);		
		Result re = new Result();
		if(u == null){
			re.setSuccess(true);
			us.addEmail(user);
			session.setAttribute("_front_user", u);
		}else{
			re.setMessage("注册失败,用户已存在");
		}
		return re;		
	}
}
