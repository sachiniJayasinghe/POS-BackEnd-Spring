package gdse68.posbackendspring.service;

import gdse68.posbackendspring.dto.CustomDTO;
import gdse68.posbackendspring.dto.OrderDetailsDTO;
import gdse68.posbackendspring.dto.OrdersDTO;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
@Transactional
public class PlaceOrderServiceImpl implements PlaceOrderService{


    @Override
    public CustomDTO OrderIdGenerate() {
        return null;
    }

    @Override
    public void placeOrder(OrdersDTO dto) {

    }

    @Override
    public CustomDTO getSumOrders() {
        return null;
    }

    @Override
    public ArrayList<OrdersDTO> LoadOrders() {
        return null;
    }

    @Override
    public ArrayList<OrderDetailsDTO> LoadOrderDetails() {
        return null;
    }
}
