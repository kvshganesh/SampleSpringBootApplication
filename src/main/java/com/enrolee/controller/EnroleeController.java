package com.enrolee.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enrolee.dto.Dependent;
import com.enrolee.dto.Enrolee;
import com.enrolee.service.EnroleeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Validated
@Api(tags = "Enrolee APIs")
@RestController
@RequestMapping(value = "/enrolee")
public class EnroleeController {
	
	@Autowired
	private EnroleeService enroleeService;

	@GetMapping(value="/{enroleeId}")
	@ApiOperation(value = "Get Enrolee details by id", notes = "Get Enrolee details by id(Id as path parameter)")
	public ResponseEntity<Enrolee> getEnrolee(@PathVariable Integer enroleeId) {
		Enrolee response =  enroleeService.getEnroleeById(enroleeId);
		return new ResponseEntity<>(response, HttpStatus.OK);
	} 
	
	@PostMapping
	@ApiOperation(value = "Create Enrolee details ", notes = "Create Enrolee. Mandatory fields : Name, Activation status, Date of birth")
	public ResponseEntity<Enrolee> createEnrolee(@RequestBody @Valid Enrolee enrolee) {
		Enrolee response = enroleeService.createEnrolee(enrolee);
		return new ResponseEntity<>(response, HttpStatus.OK);
	} 
	
	@PutMapping
	@ApiOperation(value = "Update Enrolee details ", notes = "Update Enrolee details. Mandatory fields : Id, Name, Activation status, Date of birth")
	public ResponseEntity<Enrolee> updateEnrolee(@RequestBody @Valid Enrolee enrolee) {
		Enrolee response = enroleeService.updateEnrolee(enrolee);
		return new ResponseEntity<>(response, HttpStatus.OK);
	} 
	
	@DeleteMapping(value="/{enroleeId}")
	@ApiOperation(value = "Delete Enrolee details ", notes = "Delete Enrolee details. (Association with Dependent will be removed by default.)")
	public ResponseEntity<String> deleteEnrolee(@PathVariable Integer enroleeId) {
		enroleeService.deleteEnrolee(enroleeId);
		return new ResponseEntity<>("Deleted enrolee", HttpStatus.OK);
	} 
	
}
