package com.kingdol.testspringdemo1.service;

import com.kingdol.testspringdemo1.entity.OrderEntity;
import com.kingdol.testspringdemo1.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    // 其他方法...
    public List<OrderEntity> getByUserId(int userId){
        return orderRepository.findByUserId(userId);
    }
    public void createOrder(OrderEntity order) {
        orderRepository.save(order);
    }
}
