package com.rto.restcontroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rto.entity.AddressEntity;
import com.rto.entity.OwnerEntity;
import com.rto.entity.RegistrationEntity;
import com.rto.entity.VechileEntity;
import com.rto.service.AddressService;
import com.rto.service.OwnerService;
import com.rto.service.RegistrationService;
import com.rto.service.VechileService;
import com.rto.summary.Summary;
import com.rto.userexception.UserDefineException;

@RestController
@RequestMapping("/ownerRest")
public class OwnerDetail {
	
	Logger log=LoggerFactory.getLogger(OwnerDetail.class);
	
	@Autowired
	private OwnerService ownerService;
	@Autowired
	private VechileService vechileService;
	@Autowired
	private AddressService addressService;
	@Autowired
	private RegistrationService registrationService;
	
	/*@GetMapping(name="/",produces= {"application/json","application/xml"})
	public @ResponseBody OwnerEntity getOwner(@RequestParam("oid")Integer oid) {
		OwnerEntity ownerEntity = ownerService.getById(oid);
		return ownerEntity;
	}*/
	
	@GetMapping(name="/",produces= {"application/json","application/xml"})
	public @ResponseBody Summary getOwner(@RequestParam("oid")String oid) throws UserDefineException {
		log.info("========getOwner modthod started====");
		Summary summary=new Summary();
		Integer ownerId = registrationService.findByRegNum(oid);
		 
		 OwnerEntity ownerEntity = ownerService.getById(ownerId);
		
		 VechileEntity vechileEntity=vechileService.getVechileByOwnerId(ownerId);
		 
		 AddressEntity addressByOwnerId = addressService.getAddressByOwnerId(ownerId);
		 
		 RegistrationEntity registrationByOwnerId = registrationService.getRRegistrationByOwnerId(ownerId);
		
		 summary.setOwner(ownerEntity);
		 summary.setAddress(addressByOwnerId);
		 summary.setVechile(vechileEntity);
		 summary.setRegistration(registrationByOwnerId);
		 log.info("========getOwner modthod ended====");
		 return summary;
		 
	}
}
