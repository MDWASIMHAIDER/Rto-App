package com.rto.controller;

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

import com.rto.command.VechileCommand;
import com.rto.entity.OwnerEntity;
import com.rto.entity.VechileEntity;
import com.rto.service.VechileService;

@Controller
@RequestMapping("/vechiles")
public class VechileController {
	Logger log = LoggerFactory.getLogger(VechileController.class);

	@Autowired
	private VechileService service;

	@GetMapping("/loadVechile")
	public String loadVecile(@ModelAttribute("vdcmd") VechileCommand cmd, Model model, HttpSession ses) {
		log.info("=========load vechile method executed========");
		model.addAttribute("addressId", ses.getAttribute("addressId"));
		return "vechile";
	}

	@GetMapping("/loadVechile1")
	public String handlePrvsBtn(@ModelAttribute("vdcmd") VechileCommand cmd, Model model, HttpSession ses) {
		log.info("========vechile form privious button button started======");
		Integer vechileId = (Integer) ses.getAttribute("vechileId");
		if (vechileId == null) {
			model.addAttribute("vdcmd", new VechileCommand());
			log.info("==========VechileId is null privious button========");
		} else {
			VechileEntity vechileEntity = service.getVechileById(vechileId);
			BeanUtils.copyProperties(vechileEntity, cmd);
			int vechile_Id = vechileEntity.getVechile_Id();
			OwnerEntity ownerEntity = (OwnerEntity) ses.getAttribute("ownerEntity");
			int vechile_Owner_Id = ownerEntity.getVechile_Owner_Id();
			cmd.setVechile_Id(vechile_Id);
			cmd.setVechile_Owner_Id(vechile_Owner_Id);
			model.addAttribute("vdcmd", cmd);
			model.addAttribute("vechileId", vechile_Id);
			log.info("========vechile form privious button button ended======");

		}
		return "vechile";

	}

	@PostMapping("/vechiledtl")
	public String handleNextBtn(@ModelAttribute("vdcm") VechileCommand cmd, HttpSession ses, Model model,
			RedirectAttributes redirectAttributes) {
		log.info("=======next button clicked======");
		VechileEntity entity = new VechileEntity();
		BeanUtils.copyProperties(cmd, entity);
		OwnerEntity ownerEntity = (OwnerEntity) ses.getAttribute("ownerEntity");
		entity.setDetail(ownerEntity);
		VechileEntity vechileEntity = service.saveVechile(entity);
		int vechile_Id = vechileEntity.getVechile_Id();
		model.addAttribute("rgcmd", new VechileCommand());
		ses.setAttribute("vechileEntity", vechileEntity);
		ses.setAttribute("vechileId", vechile_Id);
		log.info("=======next button clicked ended======");
		return "redirect:/registration/loadRegistration";

	}
}
