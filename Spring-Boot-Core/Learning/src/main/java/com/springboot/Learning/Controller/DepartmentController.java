package com.springboot.Learning.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.Learning.Entity.Department;
import com.springboot.Learning.Service.DepartmentService;

import jakarta.validation.Valid;

@RestController
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	 private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
	 
	 @Value("${welcome.message}")
	 private String welcomeMessage;
	 
	 @GetMapping("/")
	 public String getWelcomeMessage() {
		 return welcomeMessage;
	 }
	@PostMapping("/departments")
	public Department saveDepartment(@Valid @RequestBody Department department)
	{
		LOGGER.info("Saving  department : {}");
		return departmentService.saveDepartment(department);
	}
	
	
	@GetMapping("/departments")
	public List<Department> getDepartments()
	{
		LOGGER.info("Fetching  all departments : {}");
		return departmentService.getDepartments();
	}
	
	@GetMapping("/departments/{departmentId}")
	public Department getDepartment(@PathVariable Long departmentId)
	{
		LOGGER.info("Fetching department Based on departmentId : {}",departmentId);
		return departmentService.getDepartment(departmentId);
	}
	
	@DeleteMapping("/departments/{departmentId}")
	public String deleteDepartment(@PathVariable Long departmentId)
	{
		LOGGER.info("Deleting department Based on departmentId : {}",departmentId);
		return departmentService.deleteDepartment(departmentId);
	}
	
	@PutMapping("/departments/{departmentId}")
	public Department updateDepartment(@PathVariable Long departmentId,@RequestBody Department department) {
		LOGGER.info("Updating department Based on departmentId : {}",departmentId);
		return departmentService.updateDepartment(departmentId,department);
		
	}
	/** No Direct JPA method is available **/
	@GetMapping("/departments/name/{departmentName}")
	public Department fetchByDepartmentName(@PathVariable String departmentName)
	{
		LOGGER.info("Fetching department Based on departmentName : {}",departmentName);
		return departmentService.fetchDepartmentByName(departmentName);
	}
	
}
