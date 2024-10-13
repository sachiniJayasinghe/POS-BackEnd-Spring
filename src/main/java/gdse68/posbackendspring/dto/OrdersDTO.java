package gdse68.posbackendspring.dto;

import gdse68.posbackendspring.customObj.OrdersResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrdersDTO implements SuperDTO , OrdersResponse {
    private String orderId;
    private LocalDate orderDate;
    private String customerId;
    private BigDecimal total;
    private BigDecimal discount;
    private BigDecimal subTotal;
    private BigDecimal cash;
    private BigDecimal balance;
    private List<OrderDetailsDTO> order_list;

}
