package com.order.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.exceptions.CustomerNotFoundException;
import com.order.model.orderDetails;
import com.order.repository.orderRepository;

@Service
public class orderServiceImpl implements orderService {

	@Autowired
	private orderRepository orderRepository;

	@Override
	public List<orderDetails> getAllOrders() {

		return orderRepository.findAll();
	}

	@Override
	public orderDetails getOrdersByorderId(int id) {

		return orderRepository.findByorderId(id);
	}

	@Override
	public orderDetails findBycustomerName(String name) {

		orderDetails order = orderRepository.findAll().stream().filter(a -> a.getCustomerName().equalsIgnoreCase(name))
				.findAny().orElseThrow(null);
		if (order == null) {

			throw new CustomerNotFoundException(
					"Customer with the provided name is not found, please use the name which was used at the time of registration!");

		} else {
			return order;
		}
	}

	@Override
	public void setOrders(orderDetails order) {
//		orderRepository.save(order);
		
	        Random random = new Random();
	        order.setOrderId(random.nextInt(9999));
	        order.setPaymentStatus("Done");
	   
	        orderRepository.save(order);
	  
	    }

	@Override
	public orderDetails updateOrderByorderId(orderDetails order) {
		
		return orderRepository.save(order);

	}

}
