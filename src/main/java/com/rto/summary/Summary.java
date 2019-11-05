package com.rto.summary;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.rto.entity.AddressEntity;
import com.rto.entity.OwnerEntity;
import com.rto.entity.RegistrationEntity;
import com.rto.entity.VechileEntity;

import lombok.Data;

@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Summary {
	
	//@XmlTransient
	@XmlElement
	private OwnerEntity owner;
	@XmlElement
	//@XmlTransient
	private AddressEntity address;
	@XmlElement
	//@XmlTransient
	private VechileEntity vechile;
	@XmlElement
	//@XmlTransient
	private RegistrationEntity registration;
}
