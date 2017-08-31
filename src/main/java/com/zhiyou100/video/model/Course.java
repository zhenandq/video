package com.zhiyou100.video.model;

import java.util.Date;
import java.util.List;

public class Course {
    private Integer id;

    private String courseName;

    private String courseDescr;

    private Date insertTime;
  
    private Date updateTime;

    private Integer subjectId;
    
    private String subjectName;
    
    private Integer page;
    
    private List<video> videoList;
    
    
    
	public List<video> getVideoList() {
		return videoList;
	}

	public void setVideoList(List<video> videoList) {
		this.videoList = videoList;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName == null ? null : courseName.trim();
    }

    public String getCourseDescr() {
        return courseDescr;
    }

    public void setCourseDescr(String courseDescr) {
        this.courseDescr = courseDescr == null ? null : courseDescr.trim();
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

	@Override
	public String toString() {
		return "Course [id=" + id + ", courseName=" + courseName + ", courseDescr=" + courseDescr + ", insertTime="
				+ insertTime + ", updateTime=" + updateTime + ", subjectId=" + subjectId + ", subjectName="
				+ subjectName + ", page=" + page + "]";
	}
    
}