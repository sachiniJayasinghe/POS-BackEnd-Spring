package gdse68.posbackendspring.dao;

import gdse68.posbackendspring.entity.Item;
import gdse68.posbackendspring.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemDao extends JpaRepository<Item, String> {
}
