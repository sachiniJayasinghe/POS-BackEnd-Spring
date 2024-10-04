package gdse68.posbackendspring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.processing.Pattern;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class CustomerDTO implements SuperDTO {
    private String id;
    private String name;
    private String address;
    private String salary;
}
