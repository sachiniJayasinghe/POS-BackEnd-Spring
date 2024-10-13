package gdse68.posbackendspring.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "orders")
@Entity
public class Orders implements SuperEntity{
    @Id
    private String orderId;

    private LocalDate orderDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customerId", nullable = false)
    private Customer customer;

    private BigDecimal total;
    private BigDecimal discount;
    private BigDecimal subTotal;
    private BigDecimal cash;
    private BigDecimal balance;

}
