package com.rto.command;

import java.sql.Date;

import lombok.Data;

/*
 * This class is use  to hold Vechile form data 
 * */
@Data
public class VechileCommand {
	private int vechile_Owner_Id;
	private int vechile_Id;
	private String vechileType;
	private Integer mfgYear;
	private String vechileBrand;
	private Date create_Date;
	private Date update_Date;
}
