package com.rto.command;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

/*
 * This class is use  to hold Owner form data 
 * */
@Data
public class OwnerCommand {
	private int vechile_Owner_Id;
	private String firstName;
	private String lastName;
	private String gender;
	private String email;
	private Long phone;
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date dob;
	//private Date create_Date;
	//private Date update_Date;
}
