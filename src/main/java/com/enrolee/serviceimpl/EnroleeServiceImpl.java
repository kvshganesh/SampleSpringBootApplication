package com.enrolee.serviceimpl;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.enrolee.dto.Enrolee;
import com.enrolee.exception.EnroleeException;
import com.enrolee.reository.EnroleeRepository;
import com.enrolee.service.EnroleeService;

@Component
public class EnroleeServiceImpl implements EnroleeService{

	@Autowired
	private EnroleeRepository enroleeRepository;
	
	@Override
	public Enrolee createEnrolee(Enrolee enrolee) {
		validateEnrolee(enrolee, false);
		return enroleeRepository.save(enrolee);
	}

	@Override
	public Enrolee updateEnrolee(Enrolee enrolee) {
		validateEnrolee(enrolee, true);
		return enroleeRepository.save(enrolee);
	}

	@Override
	public Enrolee getEnroleeById(Integer id) {
		if(id == 0 || id == null) {
			throw new EnroleeException("Id cannot be null or 0 for Get request");
		}
		return enroleeRepository.findById(id).get();
	}

	@Override
	public void deleteEnrolee(Integer id) {
		if(id == 0 || id == null) {
			throw new EnroleeException("Id cannot be null or 0 for delete request");
		}
		Optional<Enrolee> enrolee = enroleeRepository.findById(id);
		enroleeRepository.delete(enrolee.get());		
	}
	
	private void validateEnrolee(@Valid Enrolee enrolee, boolean isUpdate) {
		if(!StringUtils.hasText(enrolee.getName())) {
			throw new EnroleeException("Enrolee name cannot be empty or null");
		}
		if(enrolee.getDob() == null) {
			throw new EnroleeException("Enrolee Date of Birth cannot be empty or null");
		}
		if(enrolee.getActivationStatus() == null) {
			throw new EnroleeException("Enrolee Activation Status cannot be empty or null");
		}
		if(isUpdate && (enrolee.getId() == null || enrolee.getId() == 0)) {
			throw new EnroleeException("Id cannot be null or 0 for update");
		}
	}
}