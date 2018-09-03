package com.springbootrest.pojo;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetAllCustomerResponse {
	private ArrayList<CustomerPojo> result;

	public ArrayList<CustomerPojo> getResult() {
		return result;
	}

	public void setResult(ArrayList<CustomerPojo> result) {
		this.result = result;
	}

}
