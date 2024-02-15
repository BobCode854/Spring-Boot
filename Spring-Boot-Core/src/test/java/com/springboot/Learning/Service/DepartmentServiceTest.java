package com.springboot.Learning.Service;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.springboot.Learning.Entity.Department;
import com.springboot.Learning.Repository.DepartmentRepository;

@SpringBootTest
class DepartmentServiceTest 
{
@Autowired
DepartmentService ds;

@MockBean
DepartmentRepository departmentRepo;

@BeforeEach
   void setup() {
		Department department = Department.builder().departmentName("IT").departmentAddress("Bengaluru")
				.departmentCode("ITS-IE").departmentId(1L).build();
		Mockito.when(departmentRepo.findByDepartmentName("IT")).thenReturn(department);
	}

	@Test
	@DisplayName("Get Data Based on Valid Department Name")
	public void whenValidDepartmentName_thenDepartmentShouldFound() {
		String expectedDepartmentName ="IT";
		Department actualDepartment = ds.fetchDepartmentByName(expectedDepartmentName);
		
		assertEquals(expectedDepartmentName,actualDepartment.getDepartmentName());
	}

}
