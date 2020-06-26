package com.nm.springwebclient.controller.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponse implements Serializable {
	private static final long serialVersionUID = 4145313648759396395L;

	private LocalDateTime timestamp;
	private String status;
	private String error;
	private String message;
	private String path;
}