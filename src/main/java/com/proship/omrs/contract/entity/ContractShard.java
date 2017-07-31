package com.proship.omrs.contract.entity;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.proship.omrs.base.entity.BaseEntity;
import com.proship.omrs.jsonviews.UserSerializer;
import com.proship.omrs.user.entity.User;

import lombok.Data;

@Entity
@Data
@Table(name="contract_main_shard")
public class ContractShard extends BaseEntity{
	
	
	ContractShard(){};
	
	@Id
	Long id;
	
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="contract_id")
	Contract contract;
	
	  Long act;
	  Long position;
	  Long gig_id;
	  
	  @ManyToOne(cascade = CascadeType.DETACH)
	  @JoinColumn(name="creator_id")
	  @JsonSerialize(using = UserSerializer.class)
	  User creator;
	  
	  @JsonFormat(pattern="yyyy-MM-dd")
	  Timestamp validstarttime;
	  @JsonFormat(pattern="yyyy-MM-dd")
	  Timestamp validendtime;


	Long pay_id;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Contract getContract() {
		return contract;
	}


	public void setContract(Contract contract) {
		this.contract = contract;
	}


	public Long getAct() {
		return act;
	}


	public void setAct(Long act) {
		this.act = act;
	}


	public Long getPosition() {
		return position;
	}


	public void setPosition(Long position) {
		this.position = position;
	}


	public Long getGig_id() {
		return gig_id;
	}


	public void setGig_id(Long gig_id) {
		this.gig_id = gig_id;
	}


	public User getCreator() {
		return creator;
	}


	public void setCreator(User creator) {
		this.creator = creator;
	}


	public Timestamp getValidstarttime() {
		return validstarttime;
	}


	public void setValidstarttime(Timestamp validstarttime) {

		this.validstarttime = validstarttime;
	}


	public Timestamp getValidendtime() {
		return validendtime;
	}


	public void setValidendtime(Timestamp validendtime) {
		this.validendtime = validendtime;
	}


	public Long getPay_id() {
		return pay_id;
	}


	public void setPay_id(Long pay_id) {
		this.pay_id = pay_id;
	}

	  @Override
	public String toString() {
		return "ContractShard [id=" + id + ", act=" + act + ", position=" + position + ", gig_id=" + gig_id
				+ ", creator=" + creator + ", validstarttime=" + validstarttime + ", validendtime=" + validendtime
				+ ", pay_id=" + pay_id + "]";
	}
	
}
