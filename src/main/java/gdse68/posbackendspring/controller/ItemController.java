package gdse68.posbackendspring.controller;

import gdse68.posbackendspring.customObj.CustomerResponse;
import gdse68.posbackendspring.customObj.ItemResponse;
import gdse68.posbackendspring.customObj.OrdersResponse;
import gdse68.posbackendspring.dto.CustomerDTO;
import gdse68.posbackendspring.dto.ItemDTO;
import gdse68.posbackendspring.exception.DataPersistFailedException;
import gdse68.posbackendspring.exception.OrderNotFound;
import gdse68.posbackendspring.service.CustomerService;
import gdse68.posbackendspring.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/item")
@RequiredArgsConstructor
public class ItemController {
    @Autowired
    private final ItemService itemService;
    private static final Logger logger = LoggerFactory.getLogger(AbstractReadWriteAccess.Item.class);

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createItem(@RequestBody ItemDTO item) {
        if (item == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            try {
                itemService.saveItem(item);
                logger.info("Item saved successfully: {}", item);
                return new ResponseEntity<>(HttpStatus.CREATED);
            } catch (DataPersistFailedException e) {
                logger.error("Failed to persist item data: {}", item, e);
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
    @PatchMapping(value = "/{itemCode}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateItem(@PathVariable ("itemCode") String itemCode, @RequestBody ItemDTO item) {
        try {
            if (item == null && (itemCode == null || item.equals(""))) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            itemService.updateItem(itemCode, item);
            logger.info("Item updated successfully: {}", item);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (OrderNotFound e) {
            logger.error("Item not found: ID {}", item, e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping(value ="/{itemCode}" )
    public ResponseEntity<Void> deleteItem(@PathVariable ("itemCode") String itemCode) {
        try {
            itemService.deleteItem(itemCode);
            logger.info("Item deleted successfully: ID {}", itemCode);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (OrderNotFound e) {
            logger.error("Item not found for deletion: ID {}", itemCode, e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(value = "/{itemCode}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ItemResponse getSelectedItem(@PathVariable ("itemCode") String itemCode){
        return itemService.getItemById(itemCode);
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ItemDTO> getAllItem(){
        return itemService.getAllItems();
    }
}
