package com.example.demo.models;






import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Branch {

	@Id
	int bid;
	@NotBlank(message = "Branch name is mandatory")
	String branch_name;
	@NotBlank(message = "Address is mandatory")
	String address;
	@NotEmpty(message = "Phone Number is mandatory")
	int phone_number;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="be_fk", referencedColumnName = "bid")
	List<Employeess> employes;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="bc_fk", referencedColumnName = "bid")
	List<Customers> customers;
	
	
	
	
	
	
	
}
