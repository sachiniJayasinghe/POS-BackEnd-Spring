package gdse68.posbackendspring.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "orders")
@Entity
public class Orders implements SuperEntity{
    @Id
    private String oderId;
    @ManyToOne
    @JoinColumn(name = "customerId", nullable = false)
    private Customer customer;
    private String createDate;

}
