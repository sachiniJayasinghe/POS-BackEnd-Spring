package gdse68.posbackendspring.service;

import gdse68.posbackendspring.customObj.CustomerErrorResponse;
import gdse68.posbackendspring.customObj.ItemErrorResponse;
import gdse68.posbackendspring.customObj.ItemResponse;
import gdse68.posbackendspring.customObj.OrderErrorResponse;
import gdse68.posbackendspring.dao.CustomerDao;
import gdse68.posbackendspring.dao.ItemDao;
import gdse68.posbackendspring.dto.ItemDTO;
import gdse68.posbackendspring.entity.Customer;
import gdse68.posbackendspring.entity.Item;
import gdse68.posbackendspring.entity.Orders;
import gdse68.posbackendspring.exception.CustomerNotFoundException;
import gdse68.posbackendspring.exception.ItemNotFoundException;
import gdse68.posbackendspring.exception.OrderNotFound;
import gdse68.posbackendspring.util.Mapping;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService{
    @Autowired
    private final ItemDao itemDao;
    @Autowired
    private final Mapping mapping;
    @Override
    public void saveItem(ItemDTO itemDTO) {
        if (itemDao.existsById(itemDTO.getItemCode())) {
            throw new RuntimeException("Cannot data saved");
        }
        itemDao.save(mapping.convertToItemEntity(itemDTO));

    }

    @Override
    public List<ItemDTO> getAllItems() {
        return mapping.convertItemToDTOList(itemDao.findAll());

    }

    @Override
    public ItemResponse getItemById(String id) {
        if(itemDao.existsById(id)){
            return mapping.convertToItemDTO(itemDao.getReferenceById(id));
        }else{
            throw new ItemNotFoundException("Item not found ");
        }    }

    @Override
    public void updateItem(String id, ItemDTO itemDTO) {
            Optional<Item> tmp = itemDao.findById(id);
            if (!tmp.isPresent()) {
                throw new ItemNotFoundException("item not found");
            }else {
                tmp.get().setName(itemDTO.getName());
                tmp.get().setPrice(itemDTO.getPrice());
                tmp.get().setQty(itemDTO.getQty());
            }
    }


    @Override
    public void deleteItem(String itemCode) {
        Optional<Item> findId = itemDao.findById(itemCode);
        if(!findId.isPresent()){
            throw new ItemNotFoundException("Item not found");
        }else {
            itemDao.deleteById(itemCode);
        }
    }


}
