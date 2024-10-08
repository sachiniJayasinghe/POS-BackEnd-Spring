package gdse68.posbackendspring.controller;

import gdse68.posbackendspring.customObj.CustomerResponse;
import gdse68.posbackendspring.dto.CustomerDTO;
import gdse68.posbackendspring.exception.CustomerNotFoundException;
import gdse68.posbackendspring.exception.DataPersistFailedException;
import gdse68.posbackendspring.service.CustomerService;
import gdse68.posbackendspring.util.AppUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

    @Autowired
    private final CustomerService customerService;
    //Save User
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> saveUser(
            @RequestPart("customerId") String customerId,
            @RequestPart("name") String name,
            @RequestPart ("address") String address,
            @RequestPart ("salary") String salary,
            @RequestPart ("profilePic") MultipartFile profilePic) {
        // Handle profile pic
        try {
            //byte [] imageByteCollection = profilePic.getBytes();
            String base64ProfilePic = AppUtil.toBase64ProfilePic(profilePic);
            // build the user object
            CustomerDTO buildUserDTO = new CustomerDTO();
            buildUserDTO.setCustomerId(customerId);
            buildUserDTO.setName(name);
            buildUserDTO.setAddress(address);
            buildUserDTO.setSalary(salary);
            buildUserDTO.setProfilePic(base64ProfilePic);
            //send to the service layer
            customerService.saveCustomer(buildUserDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DataPersistFailedException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping(value = "/{id}",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> updateUser(
            @PathVariable ("id") String id,
//            @RequestPart("updateCustomerId") String updateCustomerId,
            @RequestPart ("updateName") String updateName,
            @RequestPart ("updateAddress") String updateAddress,
            @RequestPart ("updateSalary") String updateSalary,
            @RequestPart ("updateProfilePic") MultipartFile updateProfilePic
    ){
        try {
            String updateBase64ProfilePic = AppUtil.toBase64ProfilePic(updateProfilePic);
            var updateCustomer = new CustomerDTO();
            updateCustomer.setCustomerId(id);
            updateCustomer.setName(updateName);
            updateCustomer.setAddress(updateAddress);
            updateCustomer.setSalary(updateSalary);
            updateCustomer.setProfilePic(updateBase64ProfilePic);
            customerService.updateCustomer(updateCustomer);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (CustomerNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable ("id") String customerId) {
        try {
            customerService.deleteCustomer(customerId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (CustomerNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public CustomerResponse getSelectedCustomer(@PathVariable ("id") String customerId){
        return customerService.getSelectedCustomer(customerId);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CustomerDTO> getAllCustomer(){
        return customerService.getAllCustomer();
    }
}
