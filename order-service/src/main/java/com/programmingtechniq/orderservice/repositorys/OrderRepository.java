package com.programmingtechniq.orderservice.repositorys;

import com.programmingtechniq.orderservice.dto.OrderRequest;
import com.programmingtechniq.orderservice.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {


}
