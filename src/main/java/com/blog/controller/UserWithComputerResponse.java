package com.blog.controller;

import com.blog.model.Computer;
import com.blog.model.User;

public class UserWithComputerResponse {
    private User user;
    private Computer computer;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Computer getComputer() {
		return computer;
	}
	public void setComputer(Computer computer) {
		this.computer = computer;
	}
}
