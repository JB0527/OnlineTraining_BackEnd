package com.ssafy.bjh.model.dao.video;

import java.util.List;

import com.ssafy.bjh.model.dto.Video;

public interface VideoDao {
	List<Video> selectList();
}
