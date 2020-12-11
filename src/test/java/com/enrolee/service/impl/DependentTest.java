package com.enrolee.service.impl;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;

import com.enrolee.dto.Dependent;
import com.enrolee.dto.Enrolee;
import com.enrolee.exception.EnroleeException;
import com.enrolee.reository.DependentRepository;
import com.enrolee.reository.EnroleeRepository;
import com.enrolee.service.DependentService;
import com.enrolee.service.EnroleeService;
import com.enrolee.serviceimpl.DependentServiceImpl;
import com.enrolee.serviceimpl.EnroleeServiceImpl;

public class DependentTest {
	private DependentService dependentService;
	private DependentRepository dependentRepository;
	
	@Before
	public void setup() {
		dependentService = new DependentServiceImpl();
		dependentRepository = Mockito.mock(DependentRepository.class);
		ReflectionTestUtils.setField(dependentService, "enroleeRepository", dependentRepository);
	}
	
	@Test
	public void testValidRecordForCreate() {
		Mockito.when(dependentRepository.save(ArgumentMatchers.any())).thenReturn(dummyRecord());
		dependentService.createDependent(dummyRecord());
		Mockito.verify(dependentRepository, Mockito.times(1)).save(ArgumentMatchers.any());
	}
	
	@Test(expected = EnroleeException.class)
	public void testNullNameForCreate() {
		Dependent dependent = dummyRecord();
		dependent.setName(null);
		Mockito.when(dependentRepository.save(ArgumentMatchers.any())).thenReturn(dummyRecord());
		dependentService.createDependent(dependent);
	}
	
	@Test(expected = EnroleeException.class)
	public void testNulldobForCreate() {
		Dependent dependent = dummyRecord();
		dependent.setDob(null);
		Mockito.when(dependentRepository.save(ArgumentMatchers.any())).thenReturn(dummyRecord());
		dependentService.createDependent(dependent);
	}

	@Test
	public void testValidRecordForUpdate() {
		Mockito.when(dependentRepository.save(ArgumentMatchers.any())).thenReturn(dummyRecord());
		dependentService.updateDependent(dummyRecord());
		Mockito.verify(dependentRepository, Mockito.times(1)).save(ArgumentMatchers.any());
	}
	
	@Test(expected = EnroleeException.class)
	public void testNullNameForUpdate() {
		Dependent dependent = dummyRecord();
		dependent.setName(null);
		Mockito.when(dependentRepository.save(ArgumentMatchers.any())).thenReturn(dummyRecord());
		dependentService.updateDependent(dependent);
	}
	
	@Test(expected = EnroleeException.class)
	public void testNulldobForUpdate() {
		Dependent dependent = dummyRecord();
		dependent.setDob(null);
		Mockito.when(dependentRepository.save(ArgumentMatchers.any())).thenReturn(dummyRecord());
		dependentService.updateDependent(dependent);
	}
	
	private Dependent dummyRecord() {
		Dependent dependent = new Dependent();
		dependent.setDob(new Date());
		dependent.setId(1);
		dependent.setName("Test");
		return dependent;
	}
}

