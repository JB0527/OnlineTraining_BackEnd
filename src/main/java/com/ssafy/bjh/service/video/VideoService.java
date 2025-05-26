package com.ssafy.bjh.service.video;

import java.util.List;

import com.ssafy.bjh.model.dto.Video;

public interface VideoService {
	List<Video> getVideoList();
	List<Video> getVideoListCountDesc();
	Video getVideoDetail(int videoId);
	boolean insertVideo(Video video);
	boolean updateVideo(Video video);
	boolean deleteVideo(int videoId);
    void incrementClickCount(int videoId);
    
}
