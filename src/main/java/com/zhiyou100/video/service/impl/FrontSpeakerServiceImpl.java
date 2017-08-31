package com.zhiyou100.video.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.video.mapper.SpeakerMapper;
import com.zhiyou100.video.model.Speaker;
import com.zhiyou100.video.service.FrontSpeakerService;
@Service
public class FrontSpeakerServiceImpl implements FrontSpeakerService {

	@Autowired
	SpeakerMapper sm;
	@Override
	public Speaker findSpeaker(Integer speakerId) {
		// TODO Auto-generated method stub
		return sm.selectByPrimaryKey(speakerId);
	}

}
