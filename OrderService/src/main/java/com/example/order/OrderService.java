package com.example.order;

import java.util.Optional;

public interface OrderService {

	public void createOrder(Order order);
	
	public Optional<Order> getOrder(int id);
	
	public Iterable<Order> getOrdersList();
}
