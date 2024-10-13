package gdse68.posbackendspring.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "items")
@Entity
public class Item implements SuperEntity{
    @Id
    private String itemCode;

    private String name;
    private int qty;
    private BigDecimal price;


}
