package com.axis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axis.dto.ApiResponse;
import com.axis.model.Order;
import com.axis.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/list")
    public ApiResponse list() {
        return orderService.findAllOrders();
    }

    @PostMapping("/save")
    public ApiResponse save(@RequestBody Order order) {
        return orderService.addOrder(order);
    }

    @PutMapping("/update")
    public ApiResponse update(@RequestBody Order order) {
        return orderService.updateOrder(order);
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse delete(@PathVariable(name = "id") String orderId) {
        return orderService.deleteOrder(orderId);
    }

    @GetMapping("/getBy/{id}")
    public ApiResponse getById(@PathVariable(name = "id") String orderId) {
        return orderService.getOrderByOrderNumber(orderId);
    }
}