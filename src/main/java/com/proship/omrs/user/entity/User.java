package com.proship.omrs.user.entity;

import java.util.List;

import javax.persistence.Access;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.proship.omrs.todoList.entity.TodoList;

import javax.persistence.AccessType;

@Entity
@Component
@Access(AccessType.FIELD)
@Table(name = "system_user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	private String name;
	private String short_name; 
	private String password_salt;
	private String password_hash;
	private String email;
	private Long  incentive_bracket_setting_id;
	private Boolean active;
	private Long uuid;
	private String extension;
	private String full_name;
	private Long evaluation_role_id;
	private Boolean requisition_mail_recipient;
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<TodoList> todoList;
	public List<TodoList> getTodoList() {
		return todoList;
	}
	public void setTodoList(List<TodoList> todoList) {
		this.todoList = todoList;
	}
	public User(){};
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getShort_name() {
		return short_name;
	}
	public void setShort_name(String short_name) {
		this.short_name = short_name;
	}
	public String getPassword_salt() {
		return password_salt;
	}
	public void setPassword_salt(String password_salt) {
		this.password_salt = password_salt;
	}
	public String getPassword_hash() {
		return password_hash;
	}
	public void setPassword_hash(String password_hash) {
		this.password_hash = password_hash;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getIncentive_bracket_setting_id() {
		return incentive_bracket_setting_id;
	}
	public void setIncentive_bracket_setting_id(Long incentive_bracket_setting_id) {
		this.incentive_bracket_setting_id = incentive_bracket_setting_id;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public Long getUuid() {
		return uuid;
	}
	public void setUuid(Long uuid) {
		this.uuid = uuid;
	}
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}
	public String getFull_name() {
		return full_name;
	}
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	public Long getEvaluation_role_id() {
		return evaluation_role_id;
	}
	public void setEvaluation_role_id(Long evaluation_role_id) {
		this.evaluation_role_id = evaluation_role_id;
	}
	public Boolean getRequisition_mail_recipient() {
		return requisition_mail_recipient;
	}
	public void setRequisition_mail_recipient(Boolean requisition_mail_recipient) {
		this.requisition_mail_recipient = requisition_mail_recipient;
	}
	
	
}
