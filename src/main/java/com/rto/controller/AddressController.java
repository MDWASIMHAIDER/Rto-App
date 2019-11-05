package com.rto.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.QueryParam;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rto.command.AddressCommand;
import com.rto.command.OwnerCommand;
import com.rto.command.VechileCommand;
import com.rto.entity.AddressEntity;
import com.rto.entity.OwnerEntity;
import com.rto.service.AddressService;
import com.rto.userexception.UserDefineException;
/*
 * This controller class is use to controll all incomming request for Address Screen
 * */
@Controller
@RequestMapping("/addressss")
public class AddressController {
	private static final Logger loog = (Logger) LoggerFactory.getLogger(AddressController.class);
	/*
	 * this reference is use for calling 
	 * addrress related repository methods
	 * */
	@Autowired
	private AddressService service;
	
	/*
	 * this method is responsible for loading address screen 
	 * */
	@GetMapping("/loadAddressForm")
	public String loadFormAddress(@ModelAttribute("addresscmd") AddressCommand cmd, Model model,
			RedirectAttributes redirectAttributes, HttpSession ses) throws UserDefineException {
		loog.info("===Owner Form Loaded===");
		model.addAttribute("oid", ses.getAttribute("oid"));

		/*
		 * int a=10; if(a!=20) { throw new UserDefineException("error occured"); }
		 */
		loog.info("=======owner form load eneded");
		return "address";
	}
	
	/*
	 * this method is responsible for 
	 * handling editing form functionality
	 * */
	@GetMapping("/loadAddress")
	public String handleAddressPrvsBtn(@ModelAttribute("addresscmd") AddressCommand cmd,
			@QueryParam("addressId") Integer aidd, Model model, HttpSession ses) {
		Integer aid = (Integer) ses.getAttribute("addressId");
		if (aid == null) {
			model.addAttribute("addresscmd", new AddressCommand());
		} else {
			loog.info("========Addres Privious button started=====");
			AddressEntity addressEntity = service.getAddressById(aid);
			BeanUtils.copyProperties(addressEntity, cmd);
			cmd.setAddress_id(aid);
			int aiddd = (int) ses.getAttribute("addressId");
			OwnerEntity entity = (OwnerEntity) ses.getAttribute("ownerEntity");
			int vechile_Owner_Id = entity.getVechile_Owner_Id();
			cmd.setVechile_Owner_Id(vechile_Owner_Id);
			cmd.setAddress_id(aiddd);
			model.addAttribute("addresscmd", cmd);
			loog.info("======address privious button ended");
			loog.info("Addres Privious button ended");
		}

		return "address";
	}

	
	/*
	 * this method is responsible for saving owner info 
	 * */
	@PostMapping("/ownerdetail")
	public String handleNextBtn(@ModelAttribute("addresscmd") AddressCommand cmd, Model model, HttpSession req,
			RedirectAttributes redirectAttributes) {
		loog.info("=======address next button clicked============");
		AddressEntity entity = new AddressEntity();
		BeanUtils.copyProperties(cmd, entity);
		OwnerEntity ownerEntity = (OwnerEntity) req.getAttribute("ownerEntity");
		entity.setDetail(ownerEntity);
		entity.setAddress_id(cmd.getAddress_id());
		AddressEntity addressEntity = service.saveAddress(entity);
		Integer addressId = addressEntity.getAddress_id();
		req.setAttribute("addressEntity", addressEntity);
		req.setAttribute("addressId", addressId);
		model.addAttribute("vechiledtl", new VechileCommand());
		loog.info("=========addrss next button ended==========");
		return "redirect:/vechiles/loadVechile";
	}
}
