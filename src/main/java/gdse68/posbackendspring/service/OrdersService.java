package gdse68.posbackendspring.service;

import gdse68.posbackendspring.customObj.OrdersResponse;
import gdse68.posbackendspring.dto.OrdersDTO;

import java.util.List;

public interface OrdersService {
    void saveOrder(OrdersDTO ordersDTO);
    void updateOrder(String orderId,OrdersDTO ordersDTO);
    void deleteOrder(String orderId);
    OrdersResponse getSelectedOrder(String orderId);
    List<OrdersDTO> getAllOrder();

}
