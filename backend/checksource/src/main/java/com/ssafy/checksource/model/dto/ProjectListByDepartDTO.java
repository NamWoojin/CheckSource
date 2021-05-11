package com.ssafy.checksource.model.dto;

import java.time.LocalDateTime;

import javax.persistence.Column;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class ProjectListByDepartDTO {

	private String projectId;
	private String name;
	private boolean status;
	private LocalDateTime date;
	private int opensourceCnt;
	private int licenseCnt;
	private String username;
	private String userId;
	
}
