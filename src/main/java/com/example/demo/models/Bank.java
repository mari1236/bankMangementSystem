package com.example.demo.models;




import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

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
public class Bank{

	

	@Id
	int bank_id;
	@NotBlank(message = "Bank Name is mandatory")
	String bank_name;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="bb_fk", referencedColumnName ="bank_id" )
	List<Branch> branch;
	
	
	
}
