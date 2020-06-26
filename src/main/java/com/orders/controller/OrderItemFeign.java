package com.orders.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.orders.model.ProductsDto;

//@FeignClient("ItemDetails")
public interface OrderItemFeign 
{
	@RequestMapping("/OrderItems/OrderItems/retreiveOrderItems/{productCode}")
	public ProductsDto getItem(@PathVariable("productCode") Integer productCode);

	@PostMapping("/OrderItems/createOrderItems")
	public ProductsDto createItem(@RequestBody ProductsDto dto);

}
