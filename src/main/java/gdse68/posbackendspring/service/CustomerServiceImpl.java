package gdse68.posbackendspring.service;

import gdse68.posbackendspring.customObj.CustomerErrorResponse;
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
        Optional<Customer> selectedCusId = customerDao.findById(customerId);
        if(!selectedCusId.isPresent()){
            throw new CustomerNotFoundException("Customer not found");
        }else {
            customerDao.deleteById(customerId);
        }
    }

    @Override
    public CustomerResponse getSelectedCustomer(String customerId) {
        if(customerDao.existsById(customerId)){
            Customer customerEntityByCusId = customerDao.getCusEntityByCustomerId(customerId);
            return mapping.convertToCustomerDTO(customerEntityByCusId);
        }else {
            return new CustomerErrorResponse(0, "Customer not found");
        }
    }


    @Override
    public List<CustomerDTO> getAllCustomer() {
        List<Customer> getAllCustomer = customerDao.findAll();
        return mapping.convertUserToDTOList(getAllCustomer);
      }
}
