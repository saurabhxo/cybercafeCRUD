package com.blog.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	
	@Column(name = "userid")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "email_id")
    private String emailId;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "assign_computer_id")
    @JsonIgnore
    private Long assignedComputerId;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    public Long getAssignedComputerId() {
        return assignedComputerId;
    }

    @JsonIgnore
    public void setAssignedComputerId(Long assignedComputerId) {
        this.assignedComputerId = assignedComputerId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public User(Long userId, String userName, String emailId, String phoneNumber) {
        this.userId = userId;
        this.userName = userName;
        this.emailId = emailId;
        this.phoneNumber = phoneNumber;
    }

    public User() {
        // Default constructor
    	assignedComputerId=0L;
    }

    @Override
    public String toString() {
        return "User [userId=" + userId + ", userName=" + userName + ", emailId=" + emailId +
                ", phoneNumber=" + phoneNumber + "]";
    }
}
