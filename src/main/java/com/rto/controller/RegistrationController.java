package com.rto.controller;



import java.util.Random;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rto.command.RegistrationCommand;
import com.rto.entity.OwnerEntity;
import com.rto.entity.RegistrationEntity;
import com.rto.service.RegistrationService;

/*
 * this class is responsible to trap all
 * incomming req from registration screen
 * */
@Controller
@RequestMapping("/registration")
public class RegistrationController {
	Logger log = LoggerFactory.getLogger(RegistrationController.class);
	
	/*
	 * to communicate with registartionRepository
	 * */
	@Autowired
	private RegistrationService service;

	/*
	 * to load registration page
	 * */
	@GetMapping("/loadRegistration")
	public String loadRegistration(@ModelAttribute("rgcmd") RegistrationCommand cmd, HttpSession ses, Model model) {
		log.info("=======Registraion Form loading started====");
		return "registration";
	}

	
	/*
	 * this method is reponsible to generate random 
	 * registarion number for allocating to user 
	 * */
	public String generateRegistrationNum() {
		log.info("========registration generation method executed=======");
		String prefix = "US-";
		String suffix = "A-";
		Random rad1 = new Random();
		Random rad2 = new Random();
		int num1 = rad1.nextInt(100);
		int num2 = rad2.nextInt(1000);
		String reg = prefix + num1 + suffix + num2;
		log.info("======rigistration generation method execution finish");
		return reg;
	}
	
	
	/*
	 * 
	 * */
	@PostMapping("/register")
	public String handleNextBtn(@ModelAttribute("rgcmd") RegistrationCommand cmd, HttpSession ses, Model model,
			RedirectAttributes redirectAttributes) {
		log.info("======registration next button click started===");
		String RegNumber = generateRegistrationNum();
		log.info("======registration generate mehod called");
		RegistrationEntity entity = new RegistrationEntity();
		BeanUtils.copyProperties(cmd, entity);
		OwnerEntity ownerEntity = (OwnerEntity) ses.getAttribute("ownerEntity");
		entity.setDetail(ownerEntity);
		entity.setVechile_Reg_Num(RegNumber);
		ses.setAttribute("RegNumber",RegNumber);
		RegistrationEntity registrationEntity = service.saveRegister(entity);
		ses.setAttribute("registrationEntity", registrationEntity);
		log.info("======registration next button click ended");
		return "redirect:/sumarry/showSummary";
	}
}
