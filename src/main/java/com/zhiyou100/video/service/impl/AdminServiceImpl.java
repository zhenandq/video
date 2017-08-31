package com.zhiyou100.video.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.video.mapper.AdminMapper;
import com.zhiyou100.video.model.Admin;
import com.zhiyou100.video.model.AdminExample;
import com.zhiyou100.video.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminMapper am;
	@Override
	
	public List<Admin> findAdminByNameAndPwd(Admin admin) {	
		AdminExample ae = new AdminExample();
		ae.createCriteria().andLoginNameEqualTo(admin.getLoginName()).andLoginPwdEqualTo(admin.getLoginPwd());
		
		return am.selectByExample(ae);
	}

}
