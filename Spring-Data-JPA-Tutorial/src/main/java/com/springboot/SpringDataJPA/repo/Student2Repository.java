package com.springboot.SpringDataJPA.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springboot.SpringDataJPA.entity.Student2;

import jakarta.transaction.Transactional;

@Repository
public interface Student2Repository extends JpaRepository<Student2, Long>
{

	
	// JPA QUERIES 
	
	public List<Student2> findByFirstName(String firstName);
	public List<Student2> findByFirstNameIgnoreCase(String firstName);
	
	public List<Student2> findByFirstNameContaining(String name);
	
	public List<Student2> findByGuardianName(String guardianName);
	
	public Student2 findByFirstNameAndEmailId(String firstName,String emailId);
	
	//public List<Student2> findByLastNameNotNull();
	
	// JPQL
	
	@Query("select s from Student2 s where s.emailId =?1")
	public Student2 getStudent2ByEmail(String emailId);
	
	@Query("select s.firstName from Student2 s where s.emailId =?1")
	public String getStudent2FirstNameByEmailId(String emailId);
	

	/**
	 *       
	 *   As we are updating or deleting we need to use @Modifying annotation.
	 *   together with @Transactional
	 *   
	 *   
	 *   
	 *   
	 *   This how @Transactional works:
	 *   
	 *    By default, CRUD methods on repository instances are transactional.
			For read operations, the transaction configuration readOnly flag is set to true.
			All others are configured with a plain @Transactional so that default transaction configuration applies.
			If you need to tweak transaction configuration for one of the methods declared in a repository you can 
			override that method and add @Transactional annotation with required attribute values.

			Another way to alter transactional behavior is to use a facade or service implementation that (typically) covers more than one repository.
			Its purpose is to define transactional boundaries for non-CRUD operations.

			If you use this approach, the transaction configuration at the repositories is then neglected, as the outer transaction (defined in the service layer) 
			configuration determines the actual one used.


	 */
	
	
	@Transactional
	@Modifying
	@Query(value="update  Student2 s set s.firstName = ?1 where  s.emailId = ?2")
	public int updateStudent2FirstNameByEmailAddress(String firstName,String emailId);
	
	
	//-----------------------Native Query----------------------------------------------------------------------
	@Query(value="select * from tbl_student2 s where s.email_address=?1",
			nativeQuery=true)
	public Student2 getStudent2ByEmailNative(String emailId);
	
	
	@Transactional
	@Modifying
	@Query(value="update  tbl_student2  set first_name = ?1 where  email_address = ?2",nativeQuery = true)
	public int updateStudent2FirstNameByEmailAddressNative(String firstName,String emailId);
	
	//Native Named Param
	@Query(value="select * from tbl_student2 s where s.email_address= :emailId",
			nativeQuery=true)
	public Student2 getStudent2ByEmailNativeNamedParam(String emailId);
	
	
}
 