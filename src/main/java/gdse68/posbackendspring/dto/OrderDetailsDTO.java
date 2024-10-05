package gdse68.posbackendspring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailsDTO implements  SuperDTO{
    private String orderId;
    private String itemCode;
    private int qty;
    private double unitPrice;
}
