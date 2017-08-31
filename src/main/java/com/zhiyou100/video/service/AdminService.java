package com.zhiyou100.video.service;

import java.util.List;

import com.zhiyou100.video.model.Admin;

public interface AdminService {
	List<Admin> findAdminByNameAndPwd(Admin admin);
}
