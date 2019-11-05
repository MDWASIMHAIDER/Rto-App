package com.rto.entity;




import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity
@Table(name="ownerentity")
public class OwnerEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int vechile_Owner_Id;
	@Column(length=12)
	private String firstName;
	@Column(length=12)
	private String lastName;
	@Column(length=6)
	private String gender;
	@Column(length=20)
	private String email;
	@Column(length=20)
	private Long phone;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dob;
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable=false)
	private Date create_Date;
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date update_Date;
	

}
