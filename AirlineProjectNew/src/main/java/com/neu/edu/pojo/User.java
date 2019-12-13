package com.neu.edu.pojo;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;


@Entity(name = "User")
public class User {

	@Id
	@SequenceGenerator(name = "userIdSequence", sequenceName = "userIdSequence", initialValue = 301)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userIdSequence")
	@Column(name = "userId")
	private long userId;

	@Column(nullable = false)
	private String username;

	
	@Column(nullable = false)
	private String password;

	@Column(nullable = false)
	private String type;
	

	public long getUserId() {
		return userId;
	}


	public void setUserId(long userId) {
		this.userId = userId;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", type=" + type + "]";
	}

	

	
	

}
