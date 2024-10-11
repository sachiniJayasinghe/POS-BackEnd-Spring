package gdse68.posbackendspring.service;

import gdse68.posbackendspring.dto.CustomDTO;
import gdse68.posbackendspring.dto.OrderDetailsDTO;
import gdse68.posbackendspring.dto.OrdersDTO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

public interface PlaceOrderService {
    CustomDTO OrderIdGenerate();

    void placeOrder( OrdersDTO dto);

    CustomDTO getSumOrders();

    ArrayList<OrdersDTO> LoadOrders();

    ArrayList<OrderDetailsDTO> LoadOrderDetails();
}
