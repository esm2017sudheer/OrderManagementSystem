package com.example.order;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderServiceRepository repository;

	@Override
	public void createOrder(Order order) {
		repository.save(order);
	}

	@Override
	public Optional<Order> getOrder(int id) {
		return repository.findById(id);
	}

	@Override
	public Iterable<Order> getOrdersList() {
		return repository.findAll();
	}

}
