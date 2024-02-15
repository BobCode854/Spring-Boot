package com.springboot.Learning.Entity;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO,generator = "department_seq")
	@SequenceGenerator(name="department_seq", allocationSize = 1)
	private Long departmentId;
	@NotBlank(message="Please provide department Name")
	@Length(max=27, min=1)
	private String departmentName;
	private String departmentAddress;
	private String departmentCode;
	
	//cascade = CascadeType.ALL
	
}
