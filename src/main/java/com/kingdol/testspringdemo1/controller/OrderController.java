package com.kingdol.testspringdemo1.controller;

import com.kingdol.testspringdemo1.api.Response;
import com.kingdol.testspringdemo1.entity.OrderEntity;
import com.kingdol.testspringdemo1.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.beans.Transient;
import java.util.List;

//http://localhost:8080/order/getByUserId?userId=1
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @GetMapping ("/getByUserId")
    public Response<?> getByUserId(int userId) {
        List<OrderEntity> orders = orderService.getByUserId(userId);
        return Response.ok(orders);
    }

    @Transient
    @PostMapping("/saveOrder")
    public Response<?> createOrder(@RequestBody OrderEntity order) {
        try{
            orderService.createOrder(order);
        }
        catch(Exception e){
            //TODO: 记录日志
            return Response.error(e.getMessage(), 500);
        }
        return Response.ok(true);
    }
}
