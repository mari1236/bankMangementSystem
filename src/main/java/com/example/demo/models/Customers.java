package com.example.demo.models;




import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
@Entity
public class Customers {

	@Id
	int c_id;
	@NotBlank(message = "Name is mandatory")
	String name;
	@NotBlank(message = "Name is mandatory")
	@Email
	String email;
	@NotBlank(message = "City is mandatory")
	String city;
	@NotBlank(message = "Phone Number is mandatory")
	@Pattern(regexp = "^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\\s\\./0-9]*$")
	String phone;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="ca_fk", referencedColumnName = "c_id")
	List<Account> accounts;
	
	
	
	
	
	
	
		
	
	
}
