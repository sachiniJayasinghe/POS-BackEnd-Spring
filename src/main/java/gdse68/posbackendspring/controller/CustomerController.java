package gdse68.posbackendspring.controller;

import gdse68.posbackendspring.dto.CustomerDTO;
import gdse68.posbackendspring.exception.DataPersistFailedException;
import gdse68.posbackendspring.service.CustomerService;
import gdse68.posbackendspring.util.AppUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
}
