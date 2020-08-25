package com.example.order;

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
import com.example.exceptions.OrderNotFoundException;

@RestController
public class OrderServiceController {

	@Autowired
	private OrderItemProxy proxy;

	@Autowired
	private OrderService orderService;

	@PostMapping("/createOrder")
	public void createOrder(@RequestBody Order order) {
		OrderItem item = new OrderItem();
		try {
			item = proxy.findById(order.getOrderItem().getItemId());
		}catch(OrderItemNotFoundException ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Order Item not found", ex);
		}
		order.setOrderItem(item);
		orderService.createOrder(order);

	}

	@GetMapping("/getOrder/{id}")
	public Optional<Order> getOrder(@PathVariable int id){
		try {
			Optional<Order> result = orderService.getOrder(id);
			return result;
		}catch(OrderNotFoundException ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Order Not Found", ex);
		}
	}

	@GetMapping("/getOrders")
	public Iterable<Order> getAllOrders() {
		Iterable<Order> orders = orderService.getOrdersList();
		if(orders != null)
			return orders;
		else
			throw new ResponseStatusException(HttpStatus.NO_CONTENT, "No Orders present");
	}

}
