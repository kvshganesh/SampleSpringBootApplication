package com.enrolee.reository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enrolee.dto.Enrolee;


@Repository
public interface EnroleeRepository extends JpaRepository<Enrolee, Integer>{
	
}
