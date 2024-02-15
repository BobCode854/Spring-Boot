package com.springboot.Learning.Service;

import java.util.List;

import com.springboot.Learning.Entity.Department;

public interface DepartmentService {

	Department saveDepartment(Department department);

	List<Department> getDepartments();

	Department getDepartment(Long departmentId);

	String deleteDepartment(Long departmentId);

	Department updateDepartment(Long departmentId, Department department);

	Department fetchDepartmentByName(String departmentName);

}
