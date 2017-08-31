package com.zhiyou100.video.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.video.mapper.SpeakerMapper;
import com.zhiyou100.video.model.Speaker;
import com.zhiyou100.video.service.SpeakerService;
import com.zhiyou100.video.utils.Page;
@Service
public class SpeakerServiceImpl implements SpeakerService {

	@Autowired
	SpeakerMapper sm;	
	@Override
	public List<Speaker> findAllSpeaker() {	
		return sm.selectByExample(null);
	}
	@Override
	public void addSpeaker(Speaker sk) {
		sm.insert(sk);		
	}
	@Override
	public Speaker findSpeakerById(Integer theId) {
		return sm.selectByPrimaryKey(theId);
	}
	@Override
	public void updateSpeaker(Speaker s) {
		sm.updateByPrimaryKeySelective(s);
		
	}
	@Override
	public void deleteSpeaker(Integer id) {

		sm.deleteByPrimaryKey(id);
	}
	@Override
	public Page<Speaker> loadPage(Integer page, String speakerName, String speakerJob) {
		
		Page<Speaker> p = new Page<>();
		p.setPage(page);
		p.setSize(5);
		p.setRows(sm.findAllSpeaker(speakerName,speakerJob,(page-1)*5));
		p.setTotal(sm.findAllSpeakerCount(speakerName,speakerJob));
		return p;
	}
	
	
	

}
