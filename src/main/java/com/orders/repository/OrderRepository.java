package com.orders.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orders.model.OrderData;

@Repository
public interface OrderRepository extends JpaRepository<OrderData,Integer>
{

}
