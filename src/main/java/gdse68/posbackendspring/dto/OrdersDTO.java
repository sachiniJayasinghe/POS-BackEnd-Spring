package gdse68.posbackendspring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrdersDTO implements SuperDTO {
    private String oderId;
    private String createDate;
    private String customerId;
}
