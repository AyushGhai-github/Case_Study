package com.order.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.model.orderDetails;
import com.order.service.orderService;
import com.order.utilities.GlobalResources;

@RestController
@RequestMapping("/order")
@CrossOrigin("*")
public class orderController {
	@Autowired
	private orderService orderservice;

	private Logger logger = GlobalResources.getLogger(orderController.class);

	// this is to get All Order details
	@GetMapping("/getall")
	public ResponseEntity<List<orderDetails>> getAllOrders() {

		List<orderDetails> list = orderservice.getAllOrders();
		String methodName = "(Get All Details Of Order)";
		logger.info(methodName + "Called");

		if (list.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));

	}

	// This is use to add new Order
	@PostMapping("/addOrder")
	public ResponseEntity<orderDetails> addOrder(@RequestBody orderDetails order) {
		String methodName = "(Data Added TO Orders)";
		logger.info(methodName + "Called");
		try {
			System.out.println(order);
			orderservice.setOrders(order);
			return ResponseEntity.ok(order);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

	// this is use to get Order by id
	@GetMapping("/order-id/{id}")
	public ResponseEntity<orderDetails> getOrderById(@PathVariable("id") int id) {
		String methodName = "(Get Data  Of Order by id)";
		logger.info(methodName + "Called");

		try {
			orderDetails order = orderservice.getOrdersByorderId(id);
			return ResponseEntity.of(Optional.of(order));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

	}

}
