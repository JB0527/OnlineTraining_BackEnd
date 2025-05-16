package com.ssafy.bjh.controller.video;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.bjh.model.dto.Video;
import com.ssafy.bjh.service.video.VideoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/video")
@CrossOrigin
public class VideoController {
	
	private final VideoService videoService;
	
	@GetMapping
	public ResponseEntity<List<Video>> getVideoList() {
		List<Video> videos = videoService.getVideoList();
		return new ResponseEntity<>(videos, HttpStatus.OK);
	}
}
