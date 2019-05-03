package com.hcl.cloud.user.constant;

import org.springframework.http.HttpStatus;

public class UserResponseEntity {
private int status;
private String message;

public int getStatus() {
	return status;
}
public void setHttpStatus(int httpStatus) {
	this.status = httpStatus;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public UserResponseEntity(int httpStatus, String message) {
	super();
	this.status = httpStatus;
	this.message = message;
}

}
