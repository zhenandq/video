package com.zhiyou100.video.service.impl;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.video.mapper.videoMapper;
import com.zhiyou100.video.model.SpeakerVO;
import com.zhiyou100.video.model.video;
import com.zhiyou100.video.model.videoExample;
import com.zhiyou100.video.service.VideoService;
import com.zhiyou100.video.utils.Page;

@Service
public class VideoServiceImpl implements VideoService {
	@Autowired
	videoMapper vm;
	@Override
	public Page<video> loadPage(Integer page, String videoTitle, int videoSpeaker, int videoCourse) {

		Page<video> p = new Page<>();
		p.setPage(page);
		p.setSize(5);
		SpeakerVO vo = new SpeakerVO();
		vo.setPage((page-1)*5);
		vo.setVideoCourse(videoCourse);
		vo.setVideoTitle(videoTitle);
		vo.setVideoSpeaker(videoSpeaker);
		p.setTotal(vm.countBySou(vo));
		p.setRows(vm.findVideoBySou(vo));
		return p;
	}
	@Override
	public void addVideo(video vo) {
		vo.setInsertTime(new Timestamp(System.currentTimeMillis()));
		vm.insertSelective(vo);
	}
	@Override
	public video findVideoById(int id) {	
		return vm.selectByPrimaryKey(id);
	}
	@Override
	public void updateVideo(video v) {

		vm.updateByPrimaryKeySelective(v);
	}
	@Override
	public void deleteVideo(int id) {

		vm.deleteByPrimaryKey(id);
	}
	@Override
	public List<SpeakerVO> findStatAvg() {
		return vm.findStatAvg();
	}
	@Override
	public String listToArray1(ArrayList<String> list1) {
		StringBuilder sb = new StringBuilder();
		sb.append("[\"");
		for(int i = 0;i<list1.size();i++){
			sb.append(list1.get(i));
			if(i == list1.size()-1){
				break;
			}
			sb.append("\",\"");
		}
		sb.append("\"]");
		return sb.toString();
	}
	@Override
	public String listToArray2(ArrayList<Double> list2) {
		Object[] arr = list2.toArray();
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for(int i = 0;i<list2.size();i++){
			sb.append(list2.get(i));
			if(i == list2.size()-1){
				break;
			}
			sb.append(",");
		}
		sb.append("]");
		return Arrays.toString(arr);
	}
	@Override
	public void batchDelete(Integer[] checkid) {

		videoExample ve = new videoExample();
		ve.createCriteria().andIdIn(Arrays.asList(checkid));
		vm.deleteByExample(ve);
	}
	@Override
	public List<video> findVideoByCourseId(Integer id) {
		List<video> list = vm.selectByCourseId(id);
		return list;
	}
	

}
