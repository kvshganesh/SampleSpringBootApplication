package com.enrolee.serviceimpl;

import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import com.enrolee.dto.Dependent;
import com.enrolee.exception.EnroleeException;
import com.enrolee.reository.DependentRepository;
import com.enrolee.service.DependentService;

@Component
public class DependentServiceImpl implements DependentService{

	@Autowired
	private DependentRepository dependentRepository;
	@Override
	public Dependent createDependent(Dependent dependent)throws EnroleeException {
		validateDependent(dependent, false);
		return dependentRepository.save(dependent);		
	}

	@Override
	public Dependent updateDependent(Dependent dependent) {
		validateDependent(dependent, true);
		return dependentRepository.save(dependent);		
	}

	@Override
	public Dependent getDependentById(Integer dependentId) {
		if(dependentId == 0 || dependentId == null) {
			throw new EnroleeException("Id cannot be null or 0 for Get request");
		}
		return dependentRepository.findById(dependentId).get();
	}

	@Override
	public void deleteDependent(Integer dependentId) {
		if(dependentId == 0 || dependentId == null) {
			throw new EnroleeException("Id cannot be null or 0 for delete");
		}
		Optional<Dependent> enrolee = dependentRepository.findById(dependentId);
		dependentRepository.delete(enrolee.get());	
	}
	
	private void validateDependent(@Valid Dependent dependent, boolean isUpdate) {
		if(!StringUtils.hasText(dependent.getName())) {
			throw new EnroleeException("Dependent name cannot be empty or null");
		}
		if(dependent.getDob() == null) {
			throw new EnroleeException("Dependent Date of Birth cannot be empty or null");
		}		
		if(isUpdate && (dependent.getId() == null || dependent.getId() == 0)) {
			throw new EnroleeException("Id cannot be null or 0 for update");
		}
	}
}