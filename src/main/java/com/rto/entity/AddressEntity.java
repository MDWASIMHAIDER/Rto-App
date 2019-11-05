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
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;


@Data
@Entity
@Table(name="addressentity")
public class AddressEntity {
	
	
	@OneToOne(targetEntity=OwnerEntity.class)
	@JoinColumn(name="vechile_Owner_Id")
	@JsonIgnore
	@XmlTransient
	private OwnerEntity detail;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int address_id;
	
	
	//private int vechile_Owner_Id;//fk
	@Column(length=6)
	private Integer homeno;
	@Column(length=12)
	private String streetName;
	@Column(length=12)
	private String city;
	@Column(length=6)
	private Integer zipCode;
	@CreationTimestamp
	@Column(updatable=false)
	private Date create_Date;
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date update_Date;
	
}
