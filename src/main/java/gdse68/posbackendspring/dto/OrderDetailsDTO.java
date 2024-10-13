package gdse68.posbackendspring.dto;

import gdse68.posbackendspring.customObj.OrderDetailResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailsDTO implements  SuperDTO, OrderDetailResponse {
    private String od_id;
    private String orderId;
    private String itemCode;
    private BigDecimal unit_price;
    private int qty;

}
