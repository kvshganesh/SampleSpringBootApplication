package com.enrolee.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
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
import com.enrolee.exception.EnroleeException;
import com.enrolee.service.DependentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Validated
@Api(tags = "Dependent APIs")
@RestController
@RequestMapping(value = "/dependent")
public class DependentController {
	@Autowired
	private DependentService dependentService;
	@GetMapping(value="/{dependentId}")
	@ApiOperation(value = "Get Dependent details by id", notes = "Get Dependent details by id(Id as path parameter)")
	 public ResponseEntity<Dependent> getDependent(@PathVariable Integer dependentId) {
		Dependent response = dependentService.getDependentById(dependentId);
		return new ResponseEntity<>(response, HttpStatus.OK);		
	} 
	
	@PostMapping
	@ApiOperation(value = "Create Dependent details ", notes = "Create Dependent Mandatory fields : Name, Date of birth and Enrolee id")
	 public ResponseEntity<Dependent> createDependent(@RequestBody Dependent dependent) {
		Dependent response = dependentService.createDependent(dependent);
		return new ResponseEntity<>(response, HttpStatus.OK);
	} 

	@PutMapping
	@ApiOperation(value = "Update Dependent details ", notes = "Update Dependent details. Mandatory fields : Id, Name, Date of birth and Enrolee id")
	 public ResponseEntity<Dependent> updateDependent(@RequestBody @Valid Dependent dependent) {
		Dependent response = dependentService.updateDependent(dependent);
		return new ResponseEntity<>(response, HttpStatus.OK);
	} 
	
	@DeleteMapping(value="/{dependentId}")
	@ApiOperation(value = "Update Dependent details ", notes = "Delete Dependent details. (Association will be removed by default.)")
	 public ResponseEntity<String> deleteDependent(@PathVariable Integer dependentId) {
		dependentService.deleteDependent(dependentId);
		return new ResponseEntity<>("Deleted dependent", HttpStatus.OK);
	}
}
