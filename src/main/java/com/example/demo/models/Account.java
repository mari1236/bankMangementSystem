package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.validation.constraints.Min;
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
@ToString
@Getter
@Setter
@Entity
public class Account {
	
    @Id
	int a_id;
    @NotEmpty(message = "Field is mandatory")
    int account_number;
    @NotEmpty(message = "Field is mandatory")
	@Enumerated(EnumType.STRING)
	@Column(name="Account_type")
	private Accout_type type;
	
	
	
	
	

}