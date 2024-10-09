package gdse68.posbackendspring.dto;

import gdse68.posbackendspring.customObj.ItemResponse;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO implements SuperDTO, ItemResponse {
  //  @Pattern(regexp = "^(I00-)[0-9]{3}$")
    private String itemCode;
   // @Pattern(regexp = "^[A-z ]{3,20}$")
    private String itemDesc;
  //  @Pattern(regexp = "^[0-9]{2,10}$")
    private int qty ;
    //@Pattern(regexp = "^[0-9]{1,}[.]?[0-9]{1}$")
    private double unitPrice;
}
