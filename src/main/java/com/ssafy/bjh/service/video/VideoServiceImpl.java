package com.ssafy.bjh.service.video;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.bjh.model.dao.VideoDao;
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

}
