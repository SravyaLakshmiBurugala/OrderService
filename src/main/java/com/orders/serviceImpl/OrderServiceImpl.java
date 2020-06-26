package com.orders.serviceImpl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orders.model.OrderData;
import com.orders.model.OrderDataDto;
import com.orders.repository.OrderRepository;
import com.orders.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService
{
	@Autowired
	OrderRepository repository;
	
	@Override
	public OrderDataDto findByOrders(Integer orderId) 
	{
		Optional<OrderData> opt = repository.findById(orderId);
		
		OrderData ord = opt.get();
		
		OrderDataDto orderDataDto=new OrderDataDto();
		
		BeanUtils.copyProperties(ord, orderDataDto);
		
		return orderDataDto;
	}

	@Override
	public boolean createOrders(OrderDataDto dto) 
	{
		boolean flag = repository.existsById(dto.getOrderId());
		
		if(flag=false)
		{	
			OrderData ord = new OrderData();
			
			BeanUtils.copyProperties(dto, ord);
			
			repository.saveAndFlush(ord);
			
			return true;
			
		}
		else
			return false;
	
	}

}
