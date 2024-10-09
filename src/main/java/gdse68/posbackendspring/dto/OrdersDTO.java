package gdse68.posbackendspring.dto;

import gdse68.posbackendspring.customObj.OrdersResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrdersDTO implements SuperDTO , OrdersResponse {
    private String oderId;
    private String createDate;
    private String customerId;
}
