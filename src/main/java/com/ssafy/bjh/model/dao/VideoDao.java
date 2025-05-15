package com.ssafy.bjh.model.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssafy.bjh.model.dto.Video;

@Repository
public interface VideoDao {
	public List<Video> selectList();
}
