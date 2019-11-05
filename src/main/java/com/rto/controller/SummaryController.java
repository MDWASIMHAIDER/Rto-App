package com.rto.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rto.entity.AddressEntity;
import com.rto.entity.OwnerEntity;
import com.rto.entity.RegistrationEntity;
import com.rto.entity.VechileEntity;
import com.rto.summary.Summary;

@Controller
@RequestMapping("/sumarry")
public class SummaryController {
	
	Logger log=LoggerFactory.getLogger(SummaryController.class);
	private OwnerEntity owner;
	private AddressEntity address;
	private VechileEntity vechile;
	private RegistrationEntity registration;
	
	@GetMapping("/showSummary")
	public String showSummary(HttpSession ses,Model model) {
		log.info("========show sumamry mehod started======");
		Summary summay=new Summary();
		owner=(OwnerEntity) ses.getAttribute("ownerEntity");
		address=(AddressEntity)ses.getAttribute("addressEntity");
		vechile=(VechileEntity)ses.getAttribute("vechileEntity");
		registration=(RegistrationEntity)ses.getAttribute("registrationEntity");
		model.addAttribute("owner",owner);
		model.addAttribute("address",address);
		model.addAttribute("vechile",vechile);
		model.addAttribute("registration",registration);
		log.info("show sumamry mehod ended");
		return "sumarry";
	}
	
	@PostMapping("/resultpage")
	public String loadRegistrationForm(Model model,HttpSession ses) {
		log.info("loading result page");
		model.addAttribute("regNo",ses.getAttribute("RegNumber"));
		return "result";
	}
}
