package gdse68.posbackendspring.dao;

import gdse68.posbackendspring.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ItemDao extends JpaRepository<Item, String> {

}
