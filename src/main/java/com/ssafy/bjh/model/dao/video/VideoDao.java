package com.ssafy.bjh.model.dao.video;

import java.util.List;

import com.ssafy.bjh.model.dto.Video;

public interface VideoDao {
	List<Video> selectList();
	List<Video> selectListDesc();
	Video getVideoDetail(int videoId);
	boolean insertVideo(Video video);
	boolean updateVideo(Video video);
	boolean deleteVideo(int videoId);
    void updateCount(int videoId);
}
