package com.programmingtechniq.orderservice.services;

import com.programmingtechniq.orderservice.dto.InventoryResponse;
import com.programmingtechniq.orderservice.dto.OrderLineItemDto;
import com.programmingtechniq.orderservice.dto.OrderRequest;
import com.programmingtechniq.orderservice.models.Order;
import com.programmingtechniq.orderservice.models.OrderLineItem;
import com.programmingtechniq.orderservice.repositorys.OrderRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderServices {

    private final OrderRepository orderRepository;

    private final WebClient.Builder webClientBuilder;


    public void placeServices(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItem> orderLineItemList = orderRequest.getOrderLineItemDtoList()
                .stream()
                .map(this::mapToDto)
                .toList();


        order.setOrderLineItemList(orderLineItemList);

        List<String> skuCodes = order.getOrderLineItemList()
                .stream()
                .map(OrderLineItem::getSkuCode)
                .toList();

        InventoryResponse[] inventoryResponseArray = webClientBuilder.build().get()
                .uri("http:///inventory-service/api/inventory",
                        uriBuilder -> uriBuilder.queryParam("skuCode",skuCodes).build())
                .retrieve()
                .bodyToMono(InventoryResponse[].class)
                .block();

       Boolean allProductsInStock = Arrays.stream(inventoryResponseArray)
               .allMatch(InventoryResponse::isInStock );

        if (allProductsInStock == true) {
        orderRepository.save(order);
        } else {
            throw new IllegalArgumentException("Product is not in stock ,please try again later");
        }
    }

    private OrderLineItem mapToDto(OrderLineItemDto orderLineItemDto) {
        OrderLineItem orderLineItem = new OrderLineItem();
        orderLineItem.setPrice(orderLineItem.getPrice());
        orderLineItem.setQuantity(orderLineItem.getQuantity());
        orderLineItem.setSkuCode(orderLineItem.getSkuCode());
        return orderLineItem;

    }
}
