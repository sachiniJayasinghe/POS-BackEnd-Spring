package gdse68.posbackendspring.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "orderDetails")
@Entity
@IdClass(OrderItem_PK.class)
public class OrderDetails implements SuperEntity{
    @Id
    private String oderId;
    @Id
    private String itemCode;
    private int qty;
    private double unitPrice;
    @ManyToOne
    @JoinColumn(name = "oderId", nullable = false)
    private Orders orders;
    @ManyToOne
    @JoinColumn(name = "itemCode", nullable = false)
    private Item item;

}
