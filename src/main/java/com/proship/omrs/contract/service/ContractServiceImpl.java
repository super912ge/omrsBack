package com.proship.omrs.contract.service;

import java.sql.Timestamp;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proship.omrs.contract.entity.Contract;
import com.proship.omrs.contract.entity.ContractStatus;
import com.proship.omrs.contract.repository.ContractRepository;
import com.proship.omrs.contract.repository.ContractStatusRepository;

@Service
public class ContractServiceImpl implements ContractService{
	
	
	
	@Autowired
	ContractRepository contractRepo;
	
	@Autowired 
	ContractStatusRepository contractStatusRepo;
	

	@Override
	public Contract reinstateContract(Long id) {
		
		Contract contract = contractRepo.findOne(id);
	
		ContractStatus statusOrig = contract.getContractStatusList().stream()
				.filter(c->c.getNexttransactiontime()
						.after(new Timestamp(System.currentTimeMillis())))
				.collect(Collectors.toList()).get(0);

		
		
		if(contract.getStatus()==true){
			
			contract.getContractStatusList().remove(statusOrig);
	
			ContractStatus status =  new ContractStatus();
	
			statusOrig.setNexttransactiontime( new Timestamp(System.currentTimeMillis()));
	
			status.setTransactiontime(new Timestamp(System.currentTimeMillis()));
	
			status.setCancel(false);
	
			status.setContract(contract);	
	
			status.setId(null);
			
			status.setCreator(statusOrig.getCreator());
	
			status.setNexttransactiontime(nextTransactionTime);
	
			contractStatusRepo.save(statusOrig);
		
			contractStatusRepo.saveAndFlush(status);
			
			contract.getContractStatusList().add(statusOrig);
			
			contract.getContractStatusList().add(status);
		}

		return contract;
	}

}
