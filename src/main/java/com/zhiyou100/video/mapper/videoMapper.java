package com.zhiyou100.video.mapper;

import com.zhiyou100.video.model.SpeakerVO;
import com.zhiyou100.video.model.video;
import com.zhiyou100.video.model.videoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface videoMapper {
    int countByExample(videoExample example);

    int deleteByExample(videoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(video record);

    int insertSelective(video record);

    List<video> selectByExample(videoExample example);

    video selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") video record, @Param("example") videoExample example);

    int updateByExample(@Param("record") video record, @Param("example") videoExample example);

    int updateByPrimaryKeySelective(video record);

    int updateByPrimaryKey(video record);
    
    List<video> findVideoBySpeaker(SpeakerVO vo);
    List<video> findVideoByPage(SpeakerVO vo);
    List<video> findVideoByCourse(SpeakerVO vo);
    List<video> findVideoByCourseAndSpeaker(SpeakerVO vo);

	int countBySou(SpeakerVO vo);

	List<video> findVideoBySou(SpeakerVO vo);

	List<SpeakerVO> findStatAvg();

	List<video> selectByCourseId(Integer id);

	List<video> findAllvideo(Integer id);
}