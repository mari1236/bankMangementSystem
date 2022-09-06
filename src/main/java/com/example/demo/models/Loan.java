package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
public class Loan{
	
	@Id
	int l_id;
	@NotEmpty(message = "Loan_Number is mandatory")
	int loan_number;
	@NotEmpty(message = "Balance is mandatory")
	int balance;
	@NotBlank(message = "Loan type is mandatory")
	String loan_type;
	
	
	
	
	

}
