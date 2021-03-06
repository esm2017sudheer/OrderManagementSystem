package com.example.order;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderServiceRepository extends CrudRepository<Order, Integer> {

}
