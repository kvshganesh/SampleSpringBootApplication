package com.enrolee.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Dependent {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer id;
	@ApiModelProperty(required = true)
	public String name;
	@ApiModelProperty(required = true)
	public Date dob;
	@ApiModelProperty(required = true)
	public Integer enrolee_id;
	
}
