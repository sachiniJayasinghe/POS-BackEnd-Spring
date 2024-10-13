package gdse68.posbackendspring.dao;

import gdse68.posbackendspring.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CustomerDao extends JpaRepository<Customer, String> {
    Customer getCusEntityByCustomerId(String customerId);

}
