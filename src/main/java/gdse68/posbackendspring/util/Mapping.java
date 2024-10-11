package gdse68.posbackendspring.util;

import gdse68.posbackendspring.dto.CustomerDTO;
import gdse68.posbackendspring.dto.ItemDTO;
import gdse68.posbackendspring.dto.OrderDetailsDTO;
import gdse68.posbackendspring.dto.OrdersDTO;
import gdse68.posbackendspring.entity.Customer;
import gdse68.posbackendspring.entity.Item;
import gdse68.posbackendspring.entity.OrderDetails;
import gdse68.posbackendspring.entity.Orders;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mapping {
    @Autowired
    private ModelMapper modelMapper;

    //matters of NoteEntity and DTO
    public OrdersDTO convertToDTO(Orders orders) {return modelMapper.map(orders, OrdersDTO.class);}
    public Orders convertToEntity(OrdersDTO dto) {return modelMapper.map(dto, Orders.class);}
    public List<OrdersDTO> convertToDTO(List<Orders> orders) {
        return modelMapper.map(orders, new TypeToken<List<OrdersDTO>>() {}.getType());
    }
    //Customer matters mapping
    public Customer convertToCustomerEntity(CustomerDTO customerDTO) {
        return modelMapper.map(customerDTO, Customer.class);
    }
    public CustomerDTO convertToCustomerDTO(Customer customer) {
        return modelMapper.map(customer,   CustomerDTO.class);
    }

    public List<CustomerDTO> convertUserToDTOList(List<Customer> customers) {
        return modelMapper.map(customers, new TypeToken<List<CustomerDTO>>() {}.getType());
    }

    //Item matters mapping
    public Item convertToItemEntity(ItemDTO itemDTO) {
        return modelMapper.map(itemDTO, Item.class);
    }
    public ItemDTO convertToItemDTO(Item item) {
        return modelMapper.map(item,   ItemDTO.class);
    }

    public List<ItemDTO> convertItemToDTOList(List<Item> items) {
        return modelMapper.map(items, new TypeToken<List<ItemDTO>>() {}.getType());
    }



}
