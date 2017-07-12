package com.proship.omrs.contract.service;

import com.proship.omrs.base.service.BaseService;
import com.proship.omrs.contract.entity.Contract;

public interface ContractService extends BaseService{
	
	
	Contract reinstateContract(Long id);
		
	

}
