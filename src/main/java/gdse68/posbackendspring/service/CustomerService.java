package gdse68.posbackendspring.service;

import gdse68.posbackendspring.customObj.CustomerResponse;
import gdse68.posbackendspring.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    void saveCustomer(CustomerDTO customerDTO);
    void updateCustomer(CustomerDTO customerDTO);
    void deleteCustomer(String customerId);
    CustomerResponse getSelectedCustomer(String customerId);
    List<CustomerDTO> getAllCustomer();
}
