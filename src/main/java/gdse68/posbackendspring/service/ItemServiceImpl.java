package gdse68.posbackendspring.service;

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
    public void updateItem(String itemCode, ItemDTO itemDTO) {
        Optional<Item> tmpItemEntity= itemDao.findById(itemCode);
        if(!tmpItemEntity.isPresent()){
            throw new OrderNotFound("Item not found");
        }else {
            tmpItemEntity.get().setItemDesc(itemDTO.getItemDesc());
            tmpItemEntity.get().setQty(itemDTO.getQty());
            tmpItemEntity.get().setUnitPrice(itemDTO.getUnitPrice());

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

    @Override
    public ItemResponse getSelectedItem(String itemCode) {
        if(itemDao.existsById(itemCode)){
            return mapping.convertToItemDTO(itemDao.getReferenceById(itemCode));
        }else {
            return new ItemErrorResponse(0,"Item not found");
        }
    }

    @Override
    public List<ItemDTO> getAllItem() {
        return List.of();
    }
}
