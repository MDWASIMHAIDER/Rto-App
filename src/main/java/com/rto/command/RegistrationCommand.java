package com.rto.command;

import java.sql.Date;

import lombok.Data;

/*
 * This class is use  to hold Registration form data 
 * */
@Data
public class RegistrationCommand {
	private String reg_center;
	private Date reg_Date;
	private Date create_Date;
	private Date update_Date;
	private String vechile_Reg_Num;
}
