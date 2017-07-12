package com.proship.omrs.contract.entity;


import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;


@Entity
//@Data
//@FieldDefaults(level = AccessLevel.PRIVATE)
public class Contract implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	Long id;
	
	Integer specialty_type;
	
	Boolean non_ps;
	
	Long uuid;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER,mappedBy="contract")
	private ContractShard contractShard;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy="contract")
	List<ContractStatus> contractStatusList;
	
	
	// contract current status 
	@Transient
	Boolean status; 
	
	Contract(){};

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getSpecialty_type() {
		return specialty_type;
	}

	public void setSpecialty_type(Integer specialty_type) {
		this.specialty_type = specialty_type;
	}

	public Boolean getNon_ps() {
		return non_ps;
	}

	public void setNon_ps(Boolean non_ps) {
		this.non_ps = non_ps;
	}

	public Long getUuid() {
		return uuid;
	}

	public void setUuid(Long uuid) {
		this.uuid = uuid;
	}

	public ContractShard getContractShard() {
		return contractShard;
	}

	public void setContractShard(ContractShard contractShard) {
		this.contractShard = contractShard;
	}

	public List<ContractStatus> getContractStatusList() {
		return contractStatusList;
	}

	public void setContractStatusList(List<ContractStatus> contractStatusList) {
		this.contractStatusList = contractStatusList;
	}

	public Boolean getStatus() {
		
		if(contractStatusList!=null&&!contractStatusList.isEmpty())
		
		status = contractStatusList.stream()
				.filter(c->c.getNexttransactiontime()
						.after(new Timestamp(System.currentTimeMillis())))
				.collect(Collectors.toList()).get(0).getCancel();
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}	
	
}
