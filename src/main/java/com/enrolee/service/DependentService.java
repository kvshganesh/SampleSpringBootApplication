package com.enrolee.service;

import com.enrolee.dto.Dependent;

public interface DependentService {
	public Dependent createDependent(Dependent enrolee);
	public Dependent updateDependent(Dependent enrolee);
	public Dependent getDependentById(Integer id);
	public void deleteDependent(Integer id);
}
