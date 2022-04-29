package com.order.service;

import java.util.List;

import com.order.model.orderDetails;

public interface orderService {

	public List<orderDetails> getAllOrders();

	public orderDetails getOrdersByorderId(int id);

	public orderDetails findBycustomerName(String name);

	public void setOrders(orderDetails order);

	public orderDetails updateOrderByorderId(orderDetails order);
}
