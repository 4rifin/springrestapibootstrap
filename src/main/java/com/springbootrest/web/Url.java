package com.springbootrest.web;

public interface Url {
	/*page ui jsp*/
	String path = "customer";
	String listCustomer = "/list-customer";
	String newCustomer = "/new-customer";
	String editCustomer = "/edit-customer";
	
	/*page value url*/
	String redirect = "redirect:";
	String pageAddNew = "/newCustomer";
	String submitAddNew = "/newCustomer/save";
	String pageEditNew = "/editCustomer/{id}";
	String submitEditNew = "/editCustomer/edit/{id}";
	String submitDeleteNew = "/deleteCustomer/{id}";
	String pageIndex = "/";
}
