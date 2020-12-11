package com.enrolee.service;

import com.enrolee.dto.Enrolee;

public interface EnroleeService {
	public Enrolee createEnrolee(Enrolee enrolee);
	public Enrolee updateEnrolee(Enrolee enrolee);
	public Enrolee getEnroleeById(Integer id);
	public void deleteEnrolee(Integer id);
}
