package com.ssafy.bjh.controller.video;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping("/{videoId}")
	public ResponseEntity<Video> getVideoDetail(@PathVariable("videoId") int videoId) {
		Video video = videoService.getVideoDetail(videoId);
		return new ResponseEntity<>(video, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<String> insertVideo(@RequestBody Video video) {
		boolean res = videoService.insertVideo(video);
		
		return new ResponseEntity<>(String.valueOf(res), HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<String> updateVideo(@RequestBody Video video) {
		boolean res = videoService.updateVideo(video);
		
		return new ResponseEntity<>(String.valueOf(res), HttpStatus.OK);
	}
	
	@DeleteMapping("/{videoId}")
	public ResponseEntity<String> deleteVideo(@PathVariable("videoId") int videoId) {
		boolean res = videoService.deleteVideo(videoId);
		
		return new ResponseEntity<>(String.valueOf(res), HttpStatus.OK);
	}
	@PatchMapping("/{videoId}/click")
    public void incrementClick(@PathVariable int videoId) {
		videoService.incrementClickCount(videoId);
    }
}
