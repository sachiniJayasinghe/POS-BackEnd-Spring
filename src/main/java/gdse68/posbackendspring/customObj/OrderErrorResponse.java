package gdse68.posbackendspring.customObj;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderErrorResponse implements OrdersResponse, Serializable {
    private int errorCode;
    private String errorMessage;
}
