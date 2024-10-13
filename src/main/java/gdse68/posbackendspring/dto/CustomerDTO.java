package gdse68.posbackendspring.dto;

import gdse68.posbackendspring.customObj.CustomerResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CustomerDTO implements SuperDTO, CustomerResponse {
//    @Pattern(regexp = "^(C00-)[0-9]{3}$")
    private String customerId;
//    @Pattern(regexp = "^[A-z ]{3,20}$")
    private String name;
//    @Pattern(regexp = "^[A-Za-z0-9/, -]{4,30}$")
    private String address;
//    @Pattern(regexp = "^[0-9]{1,}[.]?[0-9]{2}$")
    private String salary;
    private String profilePic;

}
