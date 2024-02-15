package com.springboot.Learning.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.Learning.Entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

	
	/**
	 * 
	 *    As there is no direct JPA method is available to findDepartmentByName .
	 *    But JPA gives you flexibility to give naming convention in such a way that If 
	 *    we follow, JPA will create the method body  and give query result.
	 *  **/
	
	public Department findByDepartmentName(String departmentName);
	
	public Department findByDepartmentNameIgnoreCase(String departmentName);
	
	//Native query and JPQL we need to check.
}
