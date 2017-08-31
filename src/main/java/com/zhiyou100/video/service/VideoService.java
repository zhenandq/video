package com.zhiyou100.video.service;


import java.util.ArrayList;
import java.util.List;

import com.zhiyou100.video.model.SpeakerVO;
import com.zhiyou100.video.model.video;
import com.zhiyou100.video.utils.Page;

public interface VideoService {


	Page<video> loadPage(Integer page, String videoTitle, int videoSpeaker, int videoCourse);

	void addVideo(video vo);

	video findVideoById(int id);

	void updateVideo(video v);

	void deleteVideo(int id);

	List<SpeakerVO> findStatAvg();

	String listToArray1(ArrayList<String> list1);

	String listToArray2(ArrayList<Double> list2);

	void batchDelete(Integer[] checkid);

	List<video> findVideoByCourseId(Integer id);



}
