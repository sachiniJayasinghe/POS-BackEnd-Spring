package gdse68.posbackendspring.service;

import gdse68.posbackendspring.customObj.ItemResponse;
import gdse68.posbackendspring.dao.CustomerDao;
import gdse68.posbackendspring.dao.ItemDao;
import gdse68.posbackendspring.dto.ItemDTO;
import gdse68.posbackendspring.util.Mapping;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public void updateItem(ItemDTO itemDTO) {

    }

    @Override
    public void deleteItem(String itemCode) {

    }

    @Override
    public ItemResponse getSelectedItem(String itemCode) {
        return null;
    }

    @Override
    public List<ItemDTO> getAllItem() {
        return List.of();
    }
}
