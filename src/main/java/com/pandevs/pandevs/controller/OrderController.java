package com.pandevs.pandevs.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pandevs.pandevs.model.Order;
import com.pandevs.pandevs.model.OrderStatus;
import com.pandevs.pandevs.service.OrderService;


@RestController
@RequestMapping("/orders")
public class OrderController {
	private OrderService orderService;
	
	
	@Autowired
	public OrderController(OrderService orderService) {
		super();
		this.orderService = orderService;
	}
	
	
	@GetMapping("/pandelorders")
	public List<Order> getAll(){
		return orderService.getAll();
	}
	
	// Método Post, con una estructura especifica que cumpla el contrato de la API, más una conversión de datos BLOB
	@PostMapping
	public ResponseEntity<Order> newOrder(
		@RequestParam(name = "email") String email,
		@RequestParam(name = "fechaDeOrden") Date fechaDeOrden,
		@RequestParam(name = "total") BigDecimal total,
		@RequestParam(name = "estatus") OrderStatus estatus,
		@RequestParam(name = "factura") byte[] factura
	){
	
		return orderService.newOrder(order);
	}
	
}
