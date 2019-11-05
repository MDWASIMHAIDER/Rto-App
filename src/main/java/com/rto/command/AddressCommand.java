package com.rto.command;

import java.sql.Date;

import lombok.Data;
/*
 * This class is use  to hold Address form data 
 * */
@Data
public class AddressCommand {
	private int address_id;
	private int vechile_Owner_Id;
	private Integer homeno;
	private String streetName;
	private String city;
	private Integer zipCode;
	private Date create_Date;
	private Date update_Date;
}
