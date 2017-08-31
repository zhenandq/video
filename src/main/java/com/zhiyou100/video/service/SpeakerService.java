package com.zhiyou100.video.service;

import java.util.List;

import com.zhiyou100.video.model.Speaker;
import com.zhiyou100.video.utils.Page;

public interface SpeakerService {

	List<Speaker> findAllSpeaker();

	void addSpeaker(Speaker sk);

	Speaker findSpeakerById(Integer theId);

	void updateSpeaker(Speaker s);

	void deleteSpeaker(Integer id);

	Page<Speaker> loadPage(Integer page, String speakerName, String speakerJob);
	

}
