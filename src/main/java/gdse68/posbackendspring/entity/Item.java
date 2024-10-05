package gdse68.posbackendspring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "items")
@Entity
public class Item implements SuperEntity{
    @Id
    private String itemCode;
    private String itemDesc;
    private int qty ;
    private double unitPrice;
}
