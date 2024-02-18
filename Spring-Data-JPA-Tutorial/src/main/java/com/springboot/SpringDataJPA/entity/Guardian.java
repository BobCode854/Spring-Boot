package com.springboot.SpringDataJPA.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 
 *  We are taking student2 for reference
 *  
 *  @AttributesOverrides : This annotation we use when there are already table created  and I dont want to delete
 *     the table . But whatever name I will enter into embeddable object that will override to the attribute
 *     present in embedded class reference in table.
 */


@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@AttributeOverrides({
	@AttributeOverride(name = "email",column =@Column(name="guardian_email")),
	@AttributeOverride(name = "mobile",column =@Column(name="guardian_mobile")),
	@AttributeOverride(name = "name",column =@Column(name="guardian_name"))
})
@Builder
public class Guardian {

	private String name;
	private String mobile;
	private String email;
	
}
