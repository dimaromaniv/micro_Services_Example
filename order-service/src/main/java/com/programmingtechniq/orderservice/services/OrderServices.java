package com.programmingtechniq.orderservice.services;

import com.programmingtechniq.orderservice.dto.OrderLineItemDto;
import com.programmingtechniq.orderservice.dto.OrderRequest;
import com.programmingtechniq.orderservice.models.Order;
import com.programmingtechniq.orderservice.models.OrderLineItem;
import com.programmingtechniq.orderservice.repositorys.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServices {

    private final OrderRepository orderRepository;
    public void placeServices(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItem> orderLineItemList = orderRequest.getOrderLineItemDtoList()
                .stream()
                .map(this::mapToDto)
                .toList();
        order.setOrderLineItemList(orderLineItemList);

        orderRepository.save(order);
    }

    private OrderLineItem mapToDto(OrderLineItemDto orderLineItemDto) {
        OrderLineItem orderLineItem = new OrderLineItem();
        orderLineItem.setPrice(orderLineItem.getPrice());
        orderLineItem.setQuantity(orderLineItem.getQuantity());
        orderLineItem.setSkuCode(orderLineItem.getSkuCode());
        return orderLineItem;

    }
}
