package com.Mail.example.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "Mail")
public class User {
	@Id
	private long id;
	private String name;
	private String comments;
	private String email;
	private String estimationtime;
	private String rating;
	private String mobilenum;
}
