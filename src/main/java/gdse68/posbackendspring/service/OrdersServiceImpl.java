package gdse68.posbackendspring.service;

import gdse68.posbackendspring.customObj.OrdersResponse;
import gdse68.posbackendspring.dao.OrdersDao;
import gdse68.posbackendspring.dto.OrdersDTO;
import gdse68.posbackendspring.entity.Orders;
import gdse68.posbackendspring.exception.OrderNotFound;
import gdse68.posbackendspring.util.Mapping;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional

public class OrdersServiceImpl implements OrdersService{

    @Autowired
    private OrdersDao ordersDao;
    @Autowired
    private Mapping mapping;
    @Override
    public void saveOrder(OrdersDTO ordersDTO) {
        if (ordersDao.existsById(ordersDTO.getOderId())) {
            throw new RuntimeException("Cannot data saved");
        }
        ordersDao.save(mapping.convertToEntity(ordersDTO));

    }

    @Override
    public void updateOrder(String orderId, OrdersDTO incomeOrderDTO) {
        Optional<Orders> tmpOrderEntity= ordersDao.findById(orderId);
        if(!tmpOrderEntity.isPresent()){
            throw new OrderNotFound("Order not found");
        }else {
            tmpOrderEntity.get().setOderId(incomeOrderDTO.getOderId());
            tmpOrderEntity.get().setCreateDate(incomeOrderDTO.getCreateDate());
        }
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
