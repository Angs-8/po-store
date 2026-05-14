package com.explore.service;

import com.explore.entity.Order;
import com.explore.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + id));
    }

    public Order getOrderByNumber(String orderNumber) {
        Order order = orderRepository.findByOrderNumber(orderNumber);
        if (order == null) {
            throw new RuntimeException("Order not found with number: " + orderNumber);
        }
        return order;
    }

    public List<Order> getOrdersByCustomerId(Long customerId) {
        return orderRepository.findByCustomerId(customerId);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order updateOrder(Long id, Order orderDetails) {
        Order order = getOrderById(id);
        if (orderDetails.getOrderNumber() != null) {
            order.setOrderNumber(orderDetails.getOrderNumber());
        }
        if (orderDetails.getCustomerId() != null) {
            order.setCustomerId(orderDetails.getCustomerId());
        }
        if (orderDetails.getTotalAmount() != null) {
            order.setTotalAmount(orderDetails.getTotalAmount());
        }
        if (orderDetails.getStatus() != null) {
            order.setStatus(orderDetails.getStatus());
        }
        return orderRepository.save(order);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
