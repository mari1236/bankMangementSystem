package com.example.demo.models;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Employeess {

	
	


	@Id
	int eid;
	@NotBlank(message = "Name is mandatory")
	String name;
	@NotBlank(message = "Email is mandatory")
	@Email
	String email;
	@NotBlank(message = "Address is mandatory")
	String address;
	
	
	
	

	
}
