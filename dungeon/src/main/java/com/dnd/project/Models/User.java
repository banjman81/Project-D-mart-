package com.dnd.project.Models;


import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {
 @Id
 @GeneratedValue(strategy=GenerationType.IDENTITY)
 private Long id;
 
 @NotEmpty(message="Please enter your frist name")
 private String firstName;
 
 @NotEmpty(message="Please enter your last name")
 private String lastName;
 
 
 @NotEmpty(message="Please enter an email")
 private String email;
 
 @Size(min=8, message="Password is required")
 private String password;
 
 @Transient
 private String passwordConfirmation;
 
 @NotEmpty(message="Users must agree to the terms and conditions")
 private String agreed;
 
 @Column(updatable=false)
 private Date createdAt;
 private Date updatedAt;
 
 @ManyToMany(fetch = FetchType.LAZY)
 @JoinTable(
 		name = "cart",
 		joinColumns = @JoinColumn(name = "user_id"), 
 		inverseJoinColumns = @JoinColumn(name = "item_id")
 )
 private List<Item> items;
 
 @OneToMany(mappedBy="user", fetch = FetchType.LAZY)
 private List<Item> createdItems;

 public User() {
	 
 }

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getPasswordConfirmation() {
	return passwordConfirmation;
}

public void setPasswordConfirmation(String passwordConfirmation) {
	this.passwordConfirmation = passwordConfirmation;
}


public List<Item> getItems() {
	return items;
}

public void setItems(List<Item> items) {
	this.items = items;
}

public List<Item> getCreatedItems() {
	return createdItems;
}

public void setCreatedItems(List<Item> createdItems) {
	this.createdItems = createdItems;
}

public Date getCreatedAt() {
	return createdAt;
}

public void setCreatedAt(Date createdAt) {
	this.createdAt = createdAt;
}

public Date getUpdatedAt() {
	return updatedAt;
}

public void setUpdatedAt(Date updatedAt) {
	this.updatedAt = updatedAt;
}

public String getAgreed() {
	return agreed;
}

public void setAgreed(String agreed) {
	this.agreed = agreed;
}

@PrePersist
 protected void onCreate(){
     this.createdAt = new Date();
 }
 @PreUpdate
 protected void onUpdate(){
     this.updatedAt = new Date();
 }
 
}







