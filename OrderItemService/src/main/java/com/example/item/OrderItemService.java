package com.example.item;

import java.util.Optional;

public interface OrderItemService {
	
	public void addItem(OrderItem item);
	
	public Optional<OrderItem> getItemById(int id);
	
	public Iterable<OrderItem> getAllItems();

}
