package gdse68.posbackendspring.service;

import gdse68.posbackendspring.customObj.OrderErrorResponse;
import gdse68.posbackendspring.customObj.OrdersResponse;
import gdse68.posbackendspring.dao.CustomerDao;
import gdse68.posbackendspring.dao.ItemDao;
import gdse68.posbackendspring.dao.OrderDetailsDao;
import gdse68.posbackendspring.dao.OrdersDao;
import gdse68.posbackendspring.dto.OrderDetailsDTO;
import gdse68.posbackendspring.dto.OrdersDTO;
import gdse68.posbackendspring.entity.Customer;
import gdse68.posbackendspring.entity.Item;
import gdse68.posbackendspring.entity.OrderDetails;
import gdse68.posbackendspring.entity.Orders;
import gdse68.posbackendspring.exception.DataPersistFailedException;
import gdse68.posbackendspring.exception.OrderNotFound;
import gdse68.posbackendspring.util.Mapping;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional

public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private CustomerDao customerdao;
    @Autowired
    private ItemDao itemDao;
    @Autowired
    private OrdersDao orderdao;
    @Autowired
    private OrderDetailsDao orderDetailsdao;
    @Autowired
    private Mapping mapping;

    @Override
    public void saveOrder(OrdersDTO ordersDTO) {
        // Create and populate the OrderEntity
        Orders orderEntity = new Orders();
        orderEntity.setOrderId(ordersDTO.getOrderId());
        orderEntity.setOrderDate(ordersDTO.getOrderDate());
        orderEntity.setTotal(ordersDTO.getTotal());
        orderEntity.setDiscount(ordersDTO.getDiscount());
        orderEntity.setSubTotal(ordersDTO.getSubTotal());
        orderEntity.setCash(ordersDTO.getCash());
        orderEntity.setBalance(ordersDTO.getBalance());

        // Retrieve the CustomerEntity from the database
        Customer customerEntity = customerdao.findById(ordersDTO.getCustomerId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid customer id: " + ordersDTO.getCustomerId()));
        orderEntity.setCustomer(customerEntity);

        // Save the OrderEntity
        Orders savedOrder = orderdao.save(orderEntity);

        // Process the order details and save them
        for (OrderDetailsDTO orderDetailDTO : ordersDTO.getOrder_list()) {
            OrderDetails orderDetailsEntity = new OrderDetails();
            orderDetailsEntity.setOd_id(orderDetailDTO.getOd_id());

            orderDetailsEntity.setQty(orderDetailDTO.getQty());
            orderDetailsEntity.setUnitPrice(orderDetailDTO.getPrice());

            // Retrieve the ItemEntity from the database
            Item itemEntity = itemDao.findById(orderDetailDTO.getItemCode())
                    .orElseThrow(() -> new IllegalArgumentException("Invalid item code: " + orderDetailDTO.getItemCode()));
            orderDetailsEntity.setItem(itemEntity);
            orderDetailsEntity.setOrders(savedOrder);  // Link the saved order

            // Save each OrderDetailsEntity
            orderDetailsdao.save(orderDetailsEntity);
        }

        if (savedOrder == null) {
            throw new DataPersistFailedException("Order save failed!");
        }
    }

    @Override
    public List<OrderDetailsDTO> getOrderDetails() {
        return mapping.convertOrderDetailEntityListToOrderDetailDTOList(orderDetailsdao.findAll());
    }
}
