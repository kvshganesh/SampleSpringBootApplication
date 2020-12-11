package com.enrolee.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Enrolee {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@ApiModelProperty(required = true)
	private String name;
	@ApiModelProperty(required = true)
	private Boolean activationStatus;
	@ApiModelProperty(required = true)
	private Date dob;
	private String phoneno;
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "enrolee_id")
	private List<Dependent> dependentList;

}
