package com.rto.exceptionhandler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.rto.userexception.UserDefineException;

@Controller
@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value=UserDefineException.class)
	public String showError(Model model) {
		String msg="Something Went Wrong";
		model.addAttribute("msg",msg);
		return "error";
	}
	
	@ExceptionHandler(value=NullPointerException.class)
	public String showError1(Model model) {
		String msg="Something Went Wrong";
		model.addAttribute("msg",msg);
		return "error";
	}

}
