package com.springboot.Learning.Repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.springboot.Learning.Entity.Department;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class DepartmentRepositoryTest {

	@Autowired
	private DepartmentRepository departmentRepository;
	@Autowired
	private TestEntityManager testEntityManager;
	
	private Logger LOGGER = LoggerFactory.getLogger(DepartmentRepositoryTest.class);
	
	@BeforeEach
	void setUp() throws Exception {
		Department department = Department.builder().departmentName("Mechanical Engineering").departmentCode("ME-002").build();
		testEntityManager.persist(department);
		LOGGER.info("department object ",department);
	}

	// We can go with actual data also or mock data also
	@Test
	public void whenFindById_thenReturnDepartment()
	{
		// This test case will fail If we persist other data in db 
		
		/**
		 * In the  setup() method ,
		 *   testEntityManager.persist(department); // this line will temporarily persist the data
		 *   and as soon as  we will run the test case against db it will delete the data.
		 *   
		 *   So suppose if you fill the data in your db , then running this test case successfully we need to
		 *   come to this test case and change the departmentId .
		 *   
		 *   or the other way is 
		 *   
		 *   We will run against real data in db. (Best way)
		 */
		Department department = departmentRepository.findById(3L).get();
		assertEquals(department.getDepartmentName(),"Hindi");
	}

}
