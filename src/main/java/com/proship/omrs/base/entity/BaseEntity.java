package com.proship.omrs.base.entity;

import java.sql.Timestamp;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;


@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity {

	
	private Timestamp transactiontime;
	
	private Timestamp nexttransactiontime;

	public Timestamp getTransactiontime() {
		return transactiontime;
	}

	public void setTransactiontime(Timestamp transactiontime) {
		this.transactiontime = transactiontime;
	}

	public Timestamp getNexttransactiontime() {
		return nexttransactiontime;
	}

	public void setNexttransactiontime(Timestamp nexttransactiontime) {
		this.nexttransactiontime = nexttransactiontime;
	}

	
	
	
}
