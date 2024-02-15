package com.springboot.Learning.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.Learning.Constant.ErrorConstantMessage;
import com.springboot.Learning.Entity.Department;
import com.springboot.Learning.Exception.DepartmentNotFoundException;
import com.springboot.Learning.Repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepo;

	@Override
	public Department saveDepartment(Department department) {
		return departmentRepo.save(department);
	}

	@Override
	public List<Department> getDepartments() {
	
		return departmentRepo.findAll();
	}

	@Override
	public Department getDepartment(Long departmentId) {
		
		 Optional<Department> optionalDepartmentObject=departmentRepo.findById(departmentId);
		 if(!optionalDepartmentObject.isPresent()) {
			 throw new DepartmentNotFoundException(ErrorConstantMessage.DEPARTMENT_NOT_FOUND);
		 }
		 return optionalDepartmentObject.get();
	}
	@Override
	public String deleteDepartment(Long departmentId) {
		// TODO Auto-generated method stub
		 departmentRepo.deleteById(departmentId);
		 return "Department deleted successfully";
	}

	@Override
	public Department updateDepartment(Long departmentId, Department department) {
		
		Department dbdepartment=departmentRepo.findById(departmentId).get();
		if(Objects.nonNull(department.getDepartmentName())) {
			dbdepartment.setDepartmentName(department.getDepartmentName());
		}
		if(Objects.nonNull(department.getDepartmentAddress())) {
			dbdepartment.setDepartmentAddress(department.getDepartmentAddress());
		}
		if(Objects.nonNull(department.getDepartmentCode())) {
			dbdepartment.setDepartmentCode(department.getDepartmentCode());
		}
		
		departmentRepo.save(dbdepartment);
		return dbdepartment;
	}

	@Override
	public Department fetchDepartmentByName(String departmentName) {
	return 	departmentRepo.findByDepartmentName(departmentName);
	
	}
	

}
