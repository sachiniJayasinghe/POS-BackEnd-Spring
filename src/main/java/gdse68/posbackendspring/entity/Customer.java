package gdse68.posbackendspring.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer")
@Entity
public class Customer implements SuperEntity {
    @Id
    private String customerId;
    @Column(unique = true)
    private String name;
    private String address;
    private String salary;
    @Column(columnDefinition = "LONGTEXT")
    private String profilePic;
    @OneToMany(mappedBy = "customer")
    private List<Orders> orders;
}
