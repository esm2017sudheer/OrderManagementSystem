package com.example.order;

import java.util.Collection;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name ="Order-Service")
public interface OrderItemProxy {
	
	@RequestMapping("/getItems")
	public Collection<OrderItem> findAll();
	
	@RequestMapping("/getItem/{id}")
	public OrderItem findById(@PathVariable(value ="id") int id);

}
