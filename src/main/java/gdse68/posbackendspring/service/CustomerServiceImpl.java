package gdse68.posbackendspring.service;

import gdse68.posbackendspring.customObj.CustomerResponse;
import gdse68.posbackendspring.dto.CustomerDTO;

import java.util.List;

public class CustomerServiceImpl implements CustomerService{
    @Override
    public void saveCustomer(CustomerDTO customerDTO) {

    }

    @Override
    public void updateCustomer(CustomerDTO customerDTO) {

    }

    @Override
    public void deleteCustomer(String customerId) {

    }

    @Override
    public CustomerResponse getSelectedCustomer(String customerId) {
        return null;
    }

    @Override
    public List<CustomerDTO> getAllCustomer() {
        return List.of();
    }
}
