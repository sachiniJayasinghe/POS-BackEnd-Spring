package gdse68.posbackendspring.dao;

import gdse68.posbackendspring.entity.OrderDetails;
import gdse68.posbackendspring.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsDao extends JpaRepository<OrderDetails, String>{

}
