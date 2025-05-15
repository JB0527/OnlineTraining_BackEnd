package com.ssafy.bjh.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Video {
	private int id;
	private String title;
	private String part;
	private String url;
}
