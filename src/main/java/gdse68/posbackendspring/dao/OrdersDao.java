package gdse68.posbackendspring.dao;

import gdse68.posbackendspring.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersDao extends JpaRepository<Orders, String> {

}
