package gdse68.posbackendspring.service;

import gdse68.posbackendspring.customObj.CustomerResponse;
import gdse68.posbackendspring.customObj.ItemResponse;
import gdse68.posbackendspring.dto.CustomerDTO;
import gdse68.posbackendspring.dto.ItemDTO;

import java.util.List;

public interface ItemService {
    void saveItem(ItemDTO itemDTO);

    List<ItemDTO> getAllItems();

    ItemResponse getItemById(String id);

    void updateItem(String id, ItemDTO itemDTO);

    void deleteItem(String id);
}
