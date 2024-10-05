package gdse68.posbackendspring.service;

import gdse68.posbackendspring.customObj.OrdersResponse;
import gdse68.posbackendspring.dto.OrdersDTO;

import java.util.List;

public class OrdersServiceImpl implements OrdersService{
    @Override
    public void saveOrder(OrdersDTO ordersDTO) {

    }

    @Override
    public void updateOrder(String orderId, OrdersDTO ordersDTO) {

    }

    @Override
    public void deleteOrder(String orderId) {

    }

    @Override
    public OrdersResponse getSelectedOrder(String orderId) {
        return null;
    }

    @Override
    public List<OrdersDTO> getAllOrder() {
        return List.of();
    }
}
