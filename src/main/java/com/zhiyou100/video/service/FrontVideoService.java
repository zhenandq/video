package com.zhiyou100.video.service;

import java.util.List;

import com.zhiyou100.video.model.video;

public interface FrontVideoService {

	video findAllVideo(Integer videoId);

	List<video> findAllvideo(Integer id);

	void updateVideo(video v);

	video findAllVideos(Integer videoId);

}
