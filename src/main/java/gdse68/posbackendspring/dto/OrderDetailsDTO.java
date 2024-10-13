package gdse68.posbackendspring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailsDTO implements  SuperDTO{
    private String orderId;
    private String itemCode;
    private BigDecimal unit_price;
    private int qty;

}
