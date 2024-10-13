package gdse68.posbackendspring.service;

import gdse68.posbackendspring.customObj.OrderErrorResponse;
import gdse68.posbackendspring.customObj.OrdersResponse;
import gdse68.posbackendspring.dao.CustomerDao;
import gdse68.posbackendspring.dao.ItemDao;
import gdse68.posbackendspring.dao.OrderDetailsDao;
import gdse68.posbackendspring.dao.OrdersDao;
import gdse68.posbackendspring.dto.OrderDetailsDTO;
import gdse68.posbackendspring.dto.OrdersDTO;
import gdse68.posbackendspring.entity.OrderDetails;
import gdse68.posbackendspring.entity.Orders;
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


}
