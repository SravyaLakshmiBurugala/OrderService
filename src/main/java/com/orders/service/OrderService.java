package com.orders.service;

import com.orders.model.OrderDataDto;

public interface OrderService {
	
	OrderDataDto findByOrders(Integer orderId);
	
	boolean createOrders(OrderDataDto dto);


}
