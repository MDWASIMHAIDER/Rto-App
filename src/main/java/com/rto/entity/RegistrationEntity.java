package com.rto.entity;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;


@Data
@Entity
@Table(name="registrationentity")
public class RegistrationEntity {
	@OneToOne(targetEntity=OwnerEntity.class)
	@JoinColumn(name="vechile_Owner_Id")
	 @JsonIgnore
	 @XmlTransient
	private OwnerEntity detail;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(length=6)
	private int vechile_Reg_Id;
	@Column(length=16)
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date reg_Date;
	@Column(length=16,updatable=false)
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date create_Date;
	@Column(length=16)
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date update_Date;
	@Column(length=18)
	private String vechile_Reg_Num;
	@Column(length=14)
	private String reg_center;
	
}
