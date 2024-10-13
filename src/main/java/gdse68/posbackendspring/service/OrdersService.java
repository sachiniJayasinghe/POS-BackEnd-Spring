package gdse68.posbackendspring.service;

import gdse68.posbackendspring.customObj.OrdersResponse;
import gdse68.posbackendspring.dto.OrderDetailsDTO;
import gdse68.posbackendspring.dto.OrdersDTO;

import java.util.List;

public interface OrdersService {
    void saveOrder(OrdersDTO ordersDTO);

    List<OrderDetailsDTO> getOrderDetails();
}
