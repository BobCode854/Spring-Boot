package com.springboot.Learning.Controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.springboot.Learning.Entity.Department;
import com.springboot.Learning.Service.DepartmentService;
import com.fasterxml.jackson.databind.ObjectMapper;
@WebMvcTest
class DepartmentControllerTest {

	@Autowired
	private MockMvc mockMvc;
	@MockBean
	DepartmentService departmentService;
	
	private Department department ;
	@BeforeEach
	void setUp() throws Exception 
	{
		department	= Department.builder().departmentId(4L).departmentName("ITS").departmentAddress("Ranchi")
				.departmentCode("BTS-06").build();
		
		
	}
	@Test
	public void saveDepartment() throws Exception
	{
		Department inputdepartment = Department.builder().departmentName("ITS").departmentAddress("Ranchi")
				.departmentCode("BTS-06").build();
		Mockito.when(departmentService.saveDepartment(inputdepartment)).thenReturn(department);
		
		ObjectMapper obj = new ObjectMapper();
		String requestJson = obj.writeValueAsString(inputdepartment);
		
		mockMvc.perform(MockMvcRequestBuilders.post("/departments").contentType(MediaType.APPLICATION_JSON)
				.content(requestJson)).andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void fetchDepartmentById() throws Exception
	{
		Mockito.when(departmentService.getDepartment(4L)).thenReturn(department);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/departments/4").contentType(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.status().isOk()).andExpect(jsonPath("$.departmentName").value(department.getDepartmentName()));
	}

}
