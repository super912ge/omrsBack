package com.proship.omrs.contract.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.proship.omrs.contract.entity.Contract;

public interface ContractRepository extends JpaRepository<Contract,Long>{



}
