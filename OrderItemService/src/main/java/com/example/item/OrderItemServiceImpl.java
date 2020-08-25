package com.example.item;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderItemServiceImpl implements OrderItemService {

	@Autowired
	private OrderItemRepository repository;
	
	@Override
	public void addItem(OrderItem item) {
		repository.save(item);
	}

	@Override
	public Optional<OrderItem> getItemById(int id) {
		return repository.findById(id);
	}

	@Override
	public Iterable<OrderItem> getAllItems() {
		return repository.findAll();
	}

}
