package com.zhiyou100.video.service;


import com.zhiyou100.video.model.User;

public interface UserService {

	User findUserByEmailAndPwd(User user);

	User findUserById(Integer id);

	void updateUser(User u);

	void updateAvatar(User u);

	void updatePwd(User u);

	User findUserByEmail(String email);

	void updateCaptcha(User u);

	User findUserByCaptcha(User user);

	User findUserByEmail(User user);

	void addEmail(User u);

}
