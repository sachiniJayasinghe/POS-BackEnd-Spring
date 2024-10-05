package gdse68.posbackendspring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderItem_PK implements SuperEntity, Serializable {
    private String oderId;
    private String itemCode;
}
