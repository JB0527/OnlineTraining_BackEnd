package com.ssafy.bjh.service.video;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.bjh.model.dao.video.VideoDao;
import com.ssafy.bjh.model.dto.Video;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VideoServiceImpl implements VideoService{

	private final VideoDao videoDao;
	
	@Override
	public List<Video> getVideoList() {
		return videoDao.selectList();
	}

	@Override
	public Video getVideoDetail(int videoId) {
		return videoDao.getVideoDetail(videoId);
	}

	@Override
	public boolean insertVideo(Video video) {
		return videoDao.insertVideo(video);
	}

	@Override
	public boolean updateVideo(Video video) {
		return videoDao.updateVideo(video);
	}

	@Override
	public boolean deleteVideo(int videoId) {
		return videoDao.deleteVideo(videoId);
	}

}
