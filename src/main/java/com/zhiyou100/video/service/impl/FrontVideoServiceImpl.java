package com.zhiyou100.video.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.video.mapper.videoMapper;
import com.zhiyou100.video.model.video;
import com.zhiyou100.video.service.FrontVideoService;
@Service
public class FrontVideoServiceImpl implements FrontVideoService {

	@Autowired
	videoMapper vm;
	@Override
	public video findAllVideo(Integer videoId) {
		// TODO Auto-generated method stub
		return vm.selectByPrimaryKey(videoId);
	}
	@Override
	public List<video> findAllvideo(Integer id) {
		// TODO Auto-generated method stub
		return vm.findAllvideo(id);
	}
	@Override
	public void updateVideo(video v) {

		vm.updateByPrimaryKeySelective(v);
	}
	@Override
	public video findAllVideos(Integer videoId) {
		// TODO Auto-generated method stub
		return vm.selectByPrimaryKey(videoId);
	}

}
