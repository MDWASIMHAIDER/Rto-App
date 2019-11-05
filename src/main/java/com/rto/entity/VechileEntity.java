package com.rto.entity;



import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

@Entity
@Table(name="vechileentity")
@Data
public class VechileEntity {
	
	@OneToOne(targetEntity=OwnerEntity.class)
	@JoinColumn(name="vechile_Owner_Id")
	@JsonIgnore
	@XmlTransient
	private OwnerEntity detail;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int vechile_Id;
	@Column(length=12)
	private String vechileType;
	@Column(length=5)
	private Integer mfgYear;
	@Column(length=12)
	private String vechileBrand;
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable=false)
	private Date create_Date;
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date update_Date;
	
}
