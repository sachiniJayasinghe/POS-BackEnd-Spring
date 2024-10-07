package gdse68.posbackendspring.service;

import gdse68.posbackendspring.customObj.CustomerResponse;
import gdse68.posbackendspring.dao.CustomerDao;
import gdse68.posbackendspring.dto.CustomerDTO;
import gdse68.posbackendspring.entity.Customer;
import gdse68.posbackendspring.exception.CustomerNotFoundException;
import gdse68.posbackendspring.util.Mapping;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private final CustomerDao customerDao;
    @Autowired
    private final Mapping mapping;
    @Override
    public void saveCustomer(CustomerDTO customerDTO) {
        if (customerDao.existsById(customerDTO.getCustomerId())) {
            throw new RuntimeException("Cannot data saved");
        }
        customerDao.save(mapping.convertToCustomerEntity(customerDTO));
    }

    @Override
    public void updateCustomer(CustomerDTO customerDTO) {
        Optional<Customer> tmpUser = customerDao.findById(customerDTO.getCustomerId());
        if(!tmpUser.isPresent()){
            throw new CustomerNotFoundException("Customer not found");
        }else {
            tmpUser.get().setCustomerId(customerDTO.getCustomerId());
            tmpUser.get().setName(customerDTO.getName());
            tmpUser.get().setAddress(customerDTO.getAddress());
            tmpUser.get().setSalary(customerDTO.getSalary());
            tmpUser.get().setProfilePic(customerDTO.getProfilePic());
        }

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
