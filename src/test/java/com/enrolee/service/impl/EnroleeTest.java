package com.enrolee.service.impl;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;

import com.enrolee.dto.Enrolee;
import com.enrolee.exception.EnroleeException;
import com.enrolee.reository.EnroleeRepository;
import com.enrolee.service.EnroleeService;
import com.enrolee.serviceimpl.EnroleeServiceImpl;

public class EnroleeTest {
	private EnroleeService enroleeService;
	private EnroleeRepository enroleeRepository;
	
	@Before
	public void setup() {
		enroleeService = new EnroleeServiceImpl();
		enroleeRepository = Mockito.mock(EnroleeRepository.class);
		ReflectionTestUtils.setField(enroleeService, "enroleeRepository", enroleeRepository);
	}
	
	@Test
	public void testValidRecordForCreate() {
		Mockito.when(enroleeRepository.save(ArgumentMatchers.any())).thenReturn(dummyRecord());
		enroleeService.createEnrolee(dummyRecord());
		Mockito.verify(enroleeRepository, Mockito.times(1)).save(ArgumentMatchers.any());
	}
	
	@Test(expected = EnroleeException.class)
	public void testNullNameForCreate() {
		Enrolee enrolee = dummyRecord();
		enrolee.setName(null);
		Mockito.when(enroleeRepository.save(ArgumentMatchers.any())).thenReturn(dummyRecord());
		enroleeService.createEnrolee(enrolee);
	}
	
	@Test(expected = EnroleeException.class)
	public void testNulldobForCreate() {
		Enrolee enrolee = dummyRecord();
		enrolee.setDob(null);
		Mockito.when(enroleeRepository.save(ArgumentMatchers.any())).thenReturn(dummyRecord());
		enroleeService.createEnrolee(enrolee);
	}
	
	@Test(expected = EnroleeException.class)
	public void testNullActivationStatusForCreate() {
		Enrolee enrolee = dummyRecord();
		enrolee.setActivationStatus(null);
		Mockito.when(enroleeRepository.save(ArgumentMatchers.any())).thenReturn(dummyRecord());
		enroleeService.createEnrolee(enrolee);
	}

	@Test
	public void testValidRecordForUpdate() {
		Mockito.when(enroleeRepository.save(ArgumentMatchers.any())).thenReturn(dummyRecord());
		enroleeService.updateEnrolee(dummyRecord());
		Mockito.verify(enroleeRepository, Mockito.times(1)).save(ArgumentMatchers.any());
	}
	
	@Test(expected = EnroleeException.class)
	public void testNullNameForUpdate() {
		Enrolee enrolee = dummyRecord();
		enrolee.setName(null);
		Mockito.when(enroleeRepository.save(ArgumentMatchers.any())).thenReturn(dummyRecord());
		enroleeService.updateEnrolee(enrolee);
	}
	
	@Test(expected = EnroleeException.class)
	public void testNulldobForUpdate() {
		Enrolee enrolee = dummyRecord();
		enrolee.setDob(null);
		Mockito.when(enroleeRepository.save(ArgumentMatchers.any())).thenReturn(dummyRecord());
		enroleeService.updateEnrolee(enrolee);
	}
	
	@Test(expected = EnroleeException.class)
	public void testNullActivationStatusForUpdate() {
		Enrolee enrolee = dummyRecord();
		enrolee.setActivationStatus(null);
		Mockito.when(enroleeRepository.save(ArgumentMatchers.any())).thenReturn(dummyRecord());
		enroleeService.updateEnrolee(enrolee);
	}
	
	private Enrolee dummyRecord() {
		Enrolee enrolee = new Enrolee();
		enrolee.setActivationStatus(true);
		enrolee.setDob(new Date());
		enrolee.setId(1);
		enrolee.setName("Test");
		enrolee.setPhoneno("123456");
		return enrolee;
	}
}

