package com.rto.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.ws.rs.QueryParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rto.command.AddressCommand;
import com.rto.command.OwnerCommand;
import com.rto.entity.OwnerEntity;
import com.rto.service.OwnerService;
import com.rto.userexception.UserDefineException;

/*
 * this controller class is responsible for trapping 
 * all incomming request for owner screen
 * this class is having three methods for 
 * trapping incomming request for specific goals
 * */
@Controller
@RequestMapping("/owneres")
public class OwnerController {
	/*
	 * this is logger declaration for trapping log messages(sl4j logger)
	 * */
	private static final Logger log = LoggerFactory.getLogger(OwnerController.class);
	
	/*
	 *this reference is there to communicate with service owner repository 
	 * */
	@Autowired
	private OwnerService service;
	
	/*
	 * this method is there to perform
	 *  edit operation on owner screen
	 * */
	@GetMapping("/ownerForm1")
	public String handlePrvsBtn(@ModelAttribute("ownercmd") OwnerCommand cmd, @QueryParam("oid") Integer oid, Model model) {
		if (oid == null) {
			model.addAttribute("ownercmd", new OwnerCommand());
			log.info("=========for privoius button ownerForm loading statrted=======");
		} else {
			OwnerEntity ownerEntity = service.getById(oid);
			BeanUtils.copyProperties(ownerEntity, cmd);
			model.addAttribute("ownercmd", cmd);
			log.info("=========for privoius button ownerForm loading ended=======");
		}
		return "owner";
	}

	/*
	 * this method is responsible to load 
	 * owneer screen
	 * */
	@GetMapping("/ownerForm")
	public String loadForm(@ModelAttribute("ownercmd") OwnerCommand cmd, Model model) {
		log.info("===========owner form loaded");
		return "owner";
	}

	/*
	 * this method is responsible for
	 * saving owner detail to database
	 * */
	@PostMapping("/ownerInfo")
	public String handleNextBtn(@ModelAttribute("ownercmd") OwnerCommand cmd, HttpSession req, Model model,
			RedirectAttributes redirectAttributes) throws UserDefineException {
		log.info("===========owner form next button clicked started=========");
		OwnerEntity entity = new OwnerEntity();
		BeanUtils.copyProperties(cmd, entity);
		//OwnerEntity entity1=null;
		OwnerEntity ownerEntity = service.saveOwner(entity);
		Integer oid = ownerEntity.getVechile_Owner_Id();
		req.setAttribute("ownerEntity", ownerEntity);
		req.setAttribute("oid", oid);
		model.addAttribute("addresscmd", new AddressCommand());
		log.info("===========owner form next button redirected to address form=========");
		return "redirect:/addressss/loadAddressForm";
	}
}
