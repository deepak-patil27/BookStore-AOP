package com.bridgelabz.order.service;

import com.bridgelabz.order.dto.OrderDTO;
import com.bridgelabz.order.entity.Order;

import java.util.List;

public interface IOrderService {
    public Order insertOrder(OrderDTO orderdto);

    public List<Order> getAllOrderRecords();

    public Order getOrderRecord(Integer id);

    public Order updateOrderRecord(Integer id,OrderDTO dto);

    public Order deleteOrderRecord(Integer id);

    public Order cancelOrderById(Integer id,OrderDTO dto);
}
