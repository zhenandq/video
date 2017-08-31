package com.zhiyou100.video.model;

public class SpeakerVO {

	private Speaker s;
	private String speakerName;
	private String speakerJob;
	private String videoTitle;
	private int videoSpeaker;
	private int videoCourse;
	private int Page;
	private double times;
	private String courseName;
	
	
	public double getTimes() {
		return times;
	}
	public void setTimes(double times) {
		this.times = times;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public Speaker getS() {
		return s;
	}
	public void setS(Speaker s) {
		this.s = s;
	}
	public String getSpeakerName() {
		return speakerName;
	}
	public void setSpeakerName(String speakerName) {
		this.speakerName = speakerName;
	}
	public String getSpeakerJob() {
		return speakerJob;
	}
	public void setSpeakerJob(String speakerJob) {
		this.speakerJob = speakerJob;
	}
	public String getVideoTitle() {
		return videoTitle;
	}
	public void setVideoTitle(String videoTitle) {
		this.videoTitle = videoTitle;
	}
	public int getVideoSpeaker() {
		return videoSpeaker;
	}
	public void setVideoSpeaker(int videoSpeaker) {
		this.videoSpeaker = videoSpeaker;
	}
	public int getVideoCourse() {
		return videoCourse;
	}
	public void setVideoCourse(int videoCourse) {
		this.videoCourse = videoCourse;
	}
	public int getPage() {
		return Page;
	}
	public void setPage(int page) {
		Page = page;
	}
	
	
	
	
}
