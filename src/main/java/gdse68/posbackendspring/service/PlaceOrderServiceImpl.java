package gdse68.posbackendspring.service;

import gdse68.posbackendspring.dao.ItemDao;
import gdse68.posbackendspring.dao.OrderDetailsDao;
import gdse68.posbackendspring.dao.PlaceOrderDao;
import gdse68.posbackendspring.dto.CustomDTO;
import gdse68.posbackendspring.dto.OrderDetailsDTO;
import gdse68.posbackendspring.dto.OrdersDTO;
import gdse68.posbackendspring.entity.Item;
import gdse68.posbackendspring.entity.OrderDetails;
import gdse68.posbackendspring.entity.Orders;
import gdse68.posbackendspring.util.Mapping;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
@Transactional
public class PlaceOrderServiceImpl implements PlaceOrderService{

    @Autowired
    private PlaceOrderDao placeOrderDao;

    @Autowired
    private OrderDetailsDao orderDetailsDao;

    @Autowired
    private ItemDao itemDao;

    @Autowired
    private Mapping mapping;


    @Override
    public CustomDTO OrderIdGenerate() {
        return null;
    }

    @Override
    public void placeOrder(OrdersDTO dto) {

        Orders ord = mapping.convertToEntity(dto);
        if (placeOrderDao.existsById(ord.getOderId())) {
            throw new RuntimeException("Order" + ord.getOderId() + " Already added.!");
        }
        placeOrderDao.save(ord);

        //Update Item Qty
        for (OrderDetails od : ord.getOrderDetails()) {
            Item item = itemDao.findById(od.getItemCode()).get();
            item.setQty(item.getQty() - od.getQty());
            itemDao.save(item);
        }
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
