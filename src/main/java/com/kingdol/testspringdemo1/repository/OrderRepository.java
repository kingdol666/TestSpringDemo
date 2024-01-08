package com.kingdol.testspringdemo1.repository;


import com.kingdol.testspringdemo1.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
    //根据用户id查询订单
    @Query("SELECT o FROM OrderEntity o WHERE o.userId = ?1 ORDER BY o.id DESC")
    List<OrderEntity> findByUserId(int userId);
}