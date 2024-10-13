package gdse68.posbackendspring.dao;

import gdse68.posbackendspring.entity.OrderDetails;
import gdse68.posbackendspring.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface OrderDetailsDao extends JpaRepository<OrderDetails, String>{

}
