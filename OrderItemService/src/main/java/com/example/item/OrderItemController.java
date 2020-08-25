package com.example.item;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.exceptions.OrderItemNotFoundException;

@RestController
public class OrderItemController {

	@Autowired
	private OrderItemService orderItemService;
	
	@GetMapping("/getItems")
	public Iterable<OrderItem> getOrderItems(){
		Iterable<OrderItem> items = orderItemService.getAllItems();
		if(items != null)
			return items;
		else
			throw new ResponseStatusException(HttpStatus.NO_CONTENT, "No items present");
	}
	
	@GetMapping("/getItem/{id}")
	public Optional<OrderItem> getItemById(@PathVariable int id){
		try {
			Optional<OrderItem> item = orderItemService.getItemById(id);
			return item; 
		}catch(OrderItemNotFoundException ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Order item not found", ex);
		}
	}
	
	@PostMapping("/addItem")
	public void addOrderItem(@RequestBody OrderItem item) {
		if(item != null)
			orderItemService.addItem(item);
		else
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Item value is null");
	}
	
}
