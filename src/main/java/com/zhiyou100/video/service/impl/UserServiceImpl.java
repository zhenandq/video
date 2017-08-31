package com.zhiyou100.video.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.video.mapper.UserMapper;
import com.zhiyou100.video.model.User;
import com.zhiyou100.video.model.UserExample;
import com.zhiyou100.video.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserMapper um;

	@Override
	public User findUserByEmailAndPwd(User user) {

		UserExample ue = new UserExample();
		ue.createCriteria().andEmailEqualTo(user.getEmail()).andPasswordEqualTo(user.getPassword());
		List<User> list = um.selectByExample(ue); 
		User u = new User();
		if(list.size() == 0){
			u = null;
			}else{
			u = list.get(0);
			}
		return u;
	}
	
	@Override
	public User findUserById(Integer id) {
		return um.selectByPrimaryKey(id);
	}
	//修改资料
	@Override
	public void updateUser(User u) {
		um.updateByPrimaryKeySelective(u);
	}
	//修改头像
	@Override
	public void updateAvatar(User u) {
		um.updateByPrimaryKeySelective(u);
	}
	//修改密码
	@Override
	public void updatePwd(User u) {
		um.updateByPrimaryKeySelective(u);
	}
	//发送验证邮箱
	@Override
	public User findUserByEmail(String email) {
		UserExample ue = new UserExample();
		ue.createCriteria().andEmailEqualTo(email);
		List<User> list = um.selectByExample(ue);
		User u = new User();
		if(list.size() == 0){
			u = null;
		}else{
			u = list.get(0);
		}
		return u;
	}

	@Override
	public void updateCaptcha(User u) {
		um.updateByPrimaryKeySelective(u);
	}

	@Override
	public User findUserByCaptcha(User user) {
		UserExample ue = new UserExample();
		ue.createCriteria().andCaptchaEqualTo(user.getCaptcha());
		List<User> list = um.selectByExample(ue);
		User u = new User();
		if(list.size() == 0){
			u = null;			
		}else{
			u = list.get(0);
		}
		return u;
	}

	@Override
	public User findUserByEmail(User user) {
		UserExample ue = new UserExample();
		ue.createCriteria().andEmailEqualTo(user.getEmail());
		List<User> list = um.selectByExample(ue);
		User u = new User();
		if(list.size() == 0){
			u = null;
		}else{
			u = list.get(0);
		}
		return u;
	}

	@Override
	public void addEmail(User u) {
		um.insert(u);
	}
}
