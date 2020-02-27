package com.Mail.example.Dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {
	private String name;
	private String comments;
	private String email;
	
}
