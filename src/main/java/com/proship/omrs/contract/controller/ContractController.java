package com.proship.omrs.contract.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Maps;
import com.proship.omrs.base.controller.BaseController;
import com.proship.omrs.contract.entity.Contract;
import com.proship.omrs.contract.repository.ContractRepository;
import com.proship.omrs.contract.service.ContractService;

import lombok.extern.log4j.Log4j;

@Log4j
@RestController
@RequestMapping(value="/contract/")
public class ContractController extends BaseController<Contract,Long>{
	
	@Autowired
	public ContractController(ContractRepository repo) {
		super(repo);
		
	}
	
	@Autowired
	ContractService contractService;
	
	 @RequestMapping(value="/reinstatecancel/{id}", method=RequestMethod.GET, produces = {"application/json"})
	    public ResponseEntity<Map<String, Object>> reinstateCancelStatus(@PathVariable Long id) {
	    //    Log.debug("create() with body {} of type {}", json, json.getClass());

	        Contract contract = contractService.reinstateContract(id);

	        Map<String, Object> m = Maps.newHashMap();
	        m.put("success", true);
	        m.put("updated", contract);
	        return new ResponseEntity<Map<String, Object>>(m,HttpStatus.OK);
	    }


}
