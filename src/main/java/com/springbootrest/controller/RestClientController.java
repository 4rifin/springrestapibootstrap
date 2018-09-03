package com.springbootrest.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springbootrest.pojo.CustomerDTO;
import com.springbootrest.pojo.CustomerPojo;
import com.springbootrest.pojo.MessageResponse;
import com.springbootrest.service.RestClientService;
import com.springbootrest.web.Url;

@Controller
public class RestClientController {
	
	private static String messageType = "info";
	private static String message = "failed";
	@Autowired RestClientService restClientService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String listCustomer(HttpServletRequest httpServletRequest,Model model){
		try{
			List<CustomerPojo> customerList = restClientService.listAllCustomer();
			model.addAttribute("customerList",customerList);
		}catch(Exception e){
			e.getMessage();
		}
		return Url.path +Url.listCustomer;
	}
	
	@RequestMapping(value=Url.pageEditNew, method=RequestMethod.GET)
	public String getCustomer(@PathVariable("id") long id ,HttpServletRequest httpServletRequest,Model model){
		try{
			CustomerPojo customer = restClientService.getCustomer(id);
			model.addAttribute("customer",customer);
		}catch(Exception e){
			e.getMessage();
		}
		return Url.path +Url.editCustomer;
	}
	
	@RequestMapping(value=Url.pageAddNew, method=RequestMethod.GET)
	public String addNewCustomer(HttpServletRequest httpServletRequest,Model model){
		return Url.path +Url.newCustomer;
	}
	
	@RequestMapping(value=Url.submitAddNew, method=RequestMethod.POST)
	public String AddNew(HttpServletRequest httpServletRequest,Model model,final @Valid CustomerDTO params,RedirectAttributes redirectAttrs)throws Exception{
		try{
			MessageResponse messageResponse = restClientService.postNewCustomer(params);
			if(messageResponse.getMessage().equals("Success")){
				messageType = "success";
				message = messageResponse.getMessage() + " Response Api "+ messageResponse.getStatus() + messageResponse.getStatus().getReasonPhrase();
			}else{
				messageType = "danger";
				message = messageResponse.getMessage() + " Response Api "+ messageResponse.getStatus() + messageResponse.getStatus().getReasonPhrase();
			}
			redirectAttrs.addFlashAttribute("message" , message);
			redirectAttrs.addFlashAttribute("messageType" , messageType);
		}catch (Exception e) {
			e.getMessage();
		}
		return Url.redirect+Url.pageAddNew;
	}
	
	@RequestMapping(value=Url.submitEditNew, method=RequestMethod.POST)
	public String EditNew(HttpServletRequest httpServletRequest,Model model,final @Valid CustomerPojo params,RedirectAttributes redirectAttrs)throws Exception{
		try{
			MessageResponse messageResponse = restClientService.putNewCustomer(params);
			if(messageResponse.getMessage().contains("Success")){
				messageType = "success";
				message = messageResponse.getMessage() + " Response Api "+ messageResponse.getStatus() + messageResponse.getStatus().getReasonPhrase();
			}else{
				messageType = "failed";
				message = messageResponse.getMessage() + " Response Api "+ messageResponse.getStatus() + messageResponse.getStatus().getReasonPhrase();
			}
			redirectAttrs.addFlashAttribute("message" , message);
			redirectAttrs.addFlashAttribute("messageType" , messageType);
		}catch (Exception e) {
			e.getMessage();
		}
		return Url.redirect+Url.pageEditNew;
	}
	
	@RequestMapping(value=Url.submitDeleteNew, method=RequestMethod.POST)
	public String DeleteNew(HttpServletRequest httpServletRequest,Model model,@PathVariable("id") long id,RedirectAttributes redirectAttrs)throws Exception{
		try{
			MessageResponse messageResponse = restClientService.deleteNewCustomer(id);
			if(messageResponse.getMessage().contains("Success")){
				messageType = "success";
				message = messageResponse.getMessage() + " Response Api "+ messageResponse.getStatus() + messageResponse.getStatus().getReasonPhrase();
			}else{
				messageType = "failed";
				message = messageResponse.getMessage() + " Response Api "+ messageResponse.getStatus() + messageResponse.getStatus().getReasonPhrase();
			}
			redirectAttrs.addFlashAttribute("message" , message);
			redirectAttrs.addFlashAttribute("messageType" , messageType);
		}catch (Exception e) {
			e.getMessage();
		}
		return Url.redirect+Url.pageIndex;
	}
}
