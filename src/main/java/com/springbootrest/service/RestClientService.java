package com.springbootrest.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.springbootrest.pojo.CustomerDTO;
import com.springbootrest.pojo.CustomerPojo;
import com.springbootrest.pojo.GetAllCustomerResponse;
import com.springbootrest.pojo.MessageResponse;

@Service
@Transactional
public class RestClientService {
	
	@Value("${REST.SERVICE.URI}")
    public String REST_SERVICE_URI;
	@Value("${API.All.CUSTOMER}")
    public String API_ALL_CUSTOMER;
	@Value("${API.GET.CUSTOMER}")
    public String API_GET_CUSTOMER;
	@Value("${API.SAVE.CUSTOMER}")
    public String API_SAVE_CUSTOMER;
	@Value("${API.EDIT.CUSTOMER}")
    public String API_EDIT_CUSTOMER;
	@Value("${API.DELETE.CUSTOMER}")
    public String API_DELETE_CUSTOMER;
	
	
	public List<CustomerPojo> listAllCustomer(){
        System.out.println("\nTesting listAllCustomers API-----------");
        RestTemplate restTemplate = new RestTemplate(); 
       
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Authorization", null);
		
		HttpEntity<String> request = new HttpEntity<String>(headers);
		
		ResponseEntity<GetAllCustomerResponse> responseEntity = restTemplate.exchange(REST_SERVICE_URI+API_ALL_CUSTOMER, HttpMethod.GET, request, GetAllCustomerResponse.class);
		GetAllCustomerResponse getAllCustomerResponse = responseEntity.getBody();
        return getAllCustomerResponse.getResult();
	}
	
	public CustomerPojo getCustomer(long id){
        System.out.println("\nTesting getCustomers API-----------");
        RestTemplate restTemplate = new RestTemplate(); 
       
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Authorization", null);
		
		HttpEntity<String> request = new HttpEntity<String>(headers);
		
		ResponseEntity<CustomerPojo> responseEntity = restTemplate.exchange(REST_SERVICE_URI+API_GET_CUSTOMER+id, HttpMethod.GET, request, CustomerPojo.class);
		CustomerPojo customerPojo = responseEntity.getBody();
        return customerPojo;
	}
	
	public MessageResponse postNewCustomer(CustomerDTO customerPojo){
		System.out.println("\nTesting create Customer API----------");
		
		RestTemplate restTemplate = new RestTemplate(); 
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Authorization", null);
		HttpEntity<Object> request = new HttpEntity<Object>(customerPojo, headers);
		ResponseEntity<MessageResponse> responseEntity = restTemplate.exchange(REST_SERVICE_URI+API_SAVE_CUSTOMER, HttpMethod.POST, request,MessageResponse.class);
		MessageResponse messageResponse = responseEntity.getBody();
		/*MessageResponse messageResponse = restTemplate.postForObject(REST_SERVICE_URI+API_SAVE_CUSTOMER, request, MessageResponse.class);*/
		return messageResponse;
	}
	
	public MessageResponse putNewCustomer(CustomerPojo customerPojo){
		System.out.println("\nTesting edit Customer API----------");
		
		RestTemplate restTemplate = new RestTemplate(); 
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Authorization", null);
		HttpEntity<Object> request = new HttpEntity<Object>(customerPojo, headers);
		ResponseEntity<MessageResponse> responseEntity = restTemplate.exchange(REST_SERVICE_URI+API_EDIT_CUSTOMER, HttpMethod.PUT, request,MessageResponse.class);
		MessageResponse messageResponse = responseEntity.getBody();
		/*MessageResponse messageResponse = restTemplate.postForObject(REST_SERVICE_URI+API_SAVE_CUSTOMER, request, MessageResponse.class);*/
		return messageResponse;
	}
	
	public MessageResponse deleteNewCustomer(long id){
		System.out.println("\nTesting delete Customer API----------");
		
		RestTemplate restTemplate = new RestTemplate(); 
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Authorization", null);
		HttpEntity<Object> request = new HttpEntity<Object>(headers);
		ResponseEntity<MessageResponse> responseEntity = restTemplate.exchange(REST_SERVICE_URI+API_DELETE_CUSTOMER+id, HttpMethod.DELETE, request,MessageResponse.class);
		MessageResponse messageResponse = responseEntity.getBody();
		/*MessageResponse messageResponse = restTemplate.postForObject(REST_SERVICE_URI+API_SAVE_CUSTOMER, request, MessageResponse.class);*/
		return messageResponse;
	}
}
