package com.project.spring.models;

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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@NotNull(message="Please enter a first name!")
	@Size(min=3, message="First name must be at least 3 characters long!")
	private String username;
	@NotNull(message="Please enter a first name!")
	@Size(min=2, max=100, message="First name must be 2-100 characters long!")
	private String firstName;
	@NotNull(message="Please enter a last name!")
	@Size(min=2, max=100, message="Last name must be 2-100 characters long!")
	private String lastName;
	@NotNull(message="Please enter an email!")
	@Email(message="Please enter a valid email address!")
	@Size(min=2, max=100, message="Email must be between 2-100 characters!")
	private String email;
	@NotNull(message="Please enter a password!")
	@Size(min=5, message="Password must be at least 5 characters long!")
	private String password;
	@Transient
	private String passwordConfirmation;
	@Column(updatable=false)
	@DateTimeFormat(pattern="yy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yy-MM-dd")
	private Date updatedAt;

	/*=====================================
	 * MANY TO MANY RELATIONSHIP HERE
	 * ====================================
	 */

	/*=====================================
	 * ONE TO MANY RELATIONSHIP HERE
	 * ====================================
	 */

	//    CONSTRUCTORS
	//    ---------------------------------
	public User() {
	}
	public User(String username, String fname, String lname, String email, String password) {
		this.username = username;
		this.firstName = fname;
		this.lastName = lname;
		this.email = email;
		this.password = password;
	}

	//	PrePersist and PreUpdate methods
	//	-------------------------------------
	@PrePersist
	protected void onCreate(){
		this.createdAt = new Date();
	}
	@PreUpdate
	protected void onUpdate(){
		this.updatedAt = new Date();
	}

	//	GETTERS AND SETTERS
	//	------------------------------------
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
}