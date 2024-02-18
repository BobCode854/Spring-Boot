package com.springboot.SpringDataJPA.repo;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springboot.SpringDataJPA.entity.Guardian;
import com.springboot.SpringDataJPA.entity.Student;
import com.springboot.SpringDataJPA.entity.Student2;

/**
 *        Test Case File
 *        -----------------------
 *        @SpringBootTest :  It will impact the database usually we should not use this annotation in test file.
 *        @DataJpaTest  : This annotation we should use in the test case file.
 */

@SpringBootTest 
class StudentRepositoryTest 
{
	@Autowired
	Student2Repository student2Repo;
	
	@Autowired
	StudentRepository studentRepo;

	@Test
	@DisplayName("Saving the Student")
	@Disabled
	public void saveStudent()
	{
		Student student = Student.builder().firstName("Karan").emailId("karan11@gmail.com")
				.guardianEmail("mukesh@gmail.com").guardianMobile("9534073921").guardianName("Mukesh").build();
		
		studentRepo.save(student);
	}
	
	@Test
	@DisplayName("Saving the Student With guardian info")
	@Disabled
	public void saveStudentWithEmbeddedGuardian()
	{
		Guardian guardian =  Guardian.builder().email("papa@gmail.com").name("papa").mobile("7777777777").build();
		Student2 student2 = Student2.builder().emailId("rinku@gmail.com").firstName("rinku").guardian(guardian).build();
		student2Repo.save(student2);
	}
	
	@Test
	@DisplayName("Print All Student")
	public void printAllStudent()
	{
		List<Student> studentList =studentRepo.findAll();
		System.out.println("StudentList : "+studentList);
	}
	@Test
	@DisplayName("Print Student Info With Given FIrst Name")
	public void printAllStudentByFirstName()
	{
		List<Student2> studentList =student2Repo.findByFirstName("rinku");
		System.out.println("StudentList : "+studentList);
	}
	@Test
	@DisplayName("Print Student Info With Given FIrst Name with Ignore Case")
	public void printAllStudentByFirstNameIgnoreCase()
	{
		List<Student2> studentList =student2Repo.findByFirstNameIgnoreCase("Rinku");
		System.out.println("StudentListWith Ignore Case: "+studentList);
	}
	
	@Test
	@DisplayName("Print Student Info With Given FIrst Name containing")
	public void printAllStudentByFirstNameContaining()
	{
		List<Student2> studentList =student2Repo.findByFirstNameContaining("ku");
		System.out.println("StudentList COntaining "+studentList);
	}
	
	@Test
	@DisplayName("Print the info with given guardian name")
	public void printAllByGuardianName()
	{
		List<Student2> studentList =student2Repo.findByGuardianName("papa");
		System.out.println("StudentList COntaining guardian Name "+studentList);
	}
	
	@Test
	@DisplayName("Print studentInfo by Firstname and email")
	public void printStudentByFirstNameAndEmail()
	{
		Student2 student =student2Repo.findByFirstNameAndEmailId("rinku", "rinku@gmail.com");
		System.out.println("Student with first and Email "+student);
	}
	
	// ----------------------------------------------- JPQL Method Testing --------------------------------------------------
	
	@Test
	@DisplayName("JPQL : Print studentInfo by Email")
	public void studentInfoByEmail()
	{
		Student2 student =student2Repo.getStudent2ByEmail("rinku@gmail.com");
		System.out.println("JPQL : Student By EMail : "+student);
	}
	
	@Test
	@DisplayName("JPQL : Print student FIrstName by Email Addressl")
	public void studentFirstNameByEmail()
	{
		String firstName =student2Repo.getStudent2FirstNameByEmailId("rinku@gmail.com");
		System.out.println("JPQL : Student FirstName By EMail : "+firstName);
	}
	
	@Test
	@DisplayName("JPQL : Updating student FirstName by Email Addressl")
	public void updatingStudentFirstNameByEmail()
	{
		int operationResponse =student2Repo.updateStudent2FirstNameByEmailAddress("rinku123", "rinku@gmail.com");
	     System.out.println("JPQL : Updating student FirstName by Email Addressl: "+operationResponse);
	}
	
	// ----------------------------------------------- Native Method Testing --------------------------------------------------
	
	@Test
	@DisplayName("Native : Print studentInfo by Email")
	public void studentInfoByEmailNative()
	{
		Student2 student =student2Repo.getStudent2ByEmailNative("rinku@gmail.com");
		System.out.println("Native : Student By EMail : "+student);
	}
	
	@Test
	@DisplayName("Native : Updating student FirstName by Email Addressl")
	public void updatingStudentFirstNameByEmailNative()
	{
		int operationResponse =student2Repo.updateStudent2FirstNameByEmailAddressNative("rinkuNew", "rinku@gmail.com");
		System.out.println("Native : Updating student FirstName by Email Addressl: "+operationResponse);
	}
	
	@Test
	@DisplayName("Native Named Param : Print studentInfo by Email")
	public void studentInfoByEmailNativeNamedParam()
	{
		Student2 student =student2Repo.getStudent2ByEmailNativeNamedParam("rinku@gmail.com");
		System.out.println("Native Named Param: Student By EMail : "+student);
	}
	
}
