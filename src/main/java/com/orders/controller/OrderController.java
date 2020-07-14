package com.orders.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.orders.exception.OrderNotFound;
import com.orders.model.OrderDataDto;
import com.orders.model.ProductsDto;
import com.orders.service.OrderService;

@RestController
public class OrderController 
{
	String ITEM_URL="http://localhost:5001/OrderItems/retreiveOrderItems/{productCode}";
	
	String ITEM_POST_URL="http://localhost:5001/OrderItems/createOrderItems";
	
	String ANOTHER_MY_OWN_URL = "http://myanotherownurl";


	String MY_OWN_URL = "http://myownurlsravs";
	
	String channges="test";
	String ytur ="fghgf";
	String yes="stash";

	
	
	@Autowired
	OrderService service;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired 
	OrderItemFeign orderItemFeign;
	
	@GetMapping("/getOrders")
	public OrderDataDto getOrders(@PathVariable Integer orderId)
	{
		OrderDataDto orderDto=service.findByOrders(orderId);
		
		Integer productCode = orderDto.getProductCode();
		
		ProductsDto productsDto=restTemplate.getForObject(ITEM_URL, ProductsDto.class, productCode);
		
		//productsDto productsDtofeign = orderItemFeign.getItem(productCode);
		
		orderDto.setItems(productsDto);

		return orderDto;
	}
	
	@PostMapping("/createOrder")
	public String createOrder(@RequestBody OrderDataDto orderDto)
	{
		OrderDataDto orderDataDto=service.findByOrders(orderDto.getOrderId());
		
		ProductsDto productsDto = orderDataDto.getItems();
		
		String productsDto1=restTemplate.postForObject(ITEM_POST_URL, productsDto, String.class);
		
		//productsDto productsDtofeign = orderItemFeign.getItem(productCode);
		
		//orderDto.setItems(productsDto1);
		
		//orderItemFeign.createItem(productsDto);
		
		boolean flag= service.createOrders(orderDataDto);
		
		if(flag=false)
		
		 throw new OrderNotFound();
		
		else
			
		return "Success";
			
		
	}
	
	
}
