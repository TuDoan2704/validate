package com.loginspringboot.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "user")
public class UserEntity extends BaseEntity {
	//@NotNull(message = "Khong duoc de trong muc nay!")
	@Id
	@GeneratedValue
	private Long id;
	public void setId(Long id) {
		this.id = id;
	}
	@NotBlank(message = "Khong duoc de trong muc nay!")
	@Column(name = "username")
	private String userName;
	@Column(name = "password")
	private String password;
	@ManyToMany(fetch = FetchType.EAGER)
	    @JoinTable(name = "user_role",
	        joinColumns = @JoinColumn(name = "user_id"),
	        inverseJoinColumns = @JoinColumn(name = "role_id"))
	    private List<RoleEntity> roles = new ArrayList<>();
	public UserEntity() {
		
	}
	
	public UserEntity(Long id, String userName, String password, List<RoleEntity> roles) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.roles = roles;
	}

	public List<RoleEntity> getRoles() {
		return roles;
	}
	public void setRoles(List<RoleEntity> roles) {
		this.roles = roles;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getId() {
		return id;
	}
	
}
