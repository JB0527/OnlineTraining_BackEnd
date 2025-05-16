package com.ssafy.bjh.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Review {
	private int reviewId; // 리뷰의 고유 번호
	private int videoId; // 리뷰와 관련한 비디오의 번호
	private String title;
	private String content;
	private String writedTime;
	private int clickCount;
	private String writer;
	private String writerId;
}