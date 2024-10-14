package gdse68.posbackendspring.controller;

import gdse68.posbackendspring.dto.OrderDetailsDTO;
import gdse68.posbackendspring.dto.OrdersDTO;
import gdse68.posbackendspring.exception.DataPersistFailedException;
import gdse68.posbackendspring.service.OrdersService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/order")
@RequiredArgsConstructor
public class PlaceOrderController {
    @Autowired
    private final OrdersService ordersService;

    private static final Logger logger = LoggerFactory.getLogger(PlaceOrderController.class);

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> placeOrder(@RequestBody OrdersDTO orderDTO) {
        if (orderDTO == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            try {
                ordersService.saveOrder(orderDTO);
                logger.info("Order placed successfully: {}", orderDTO);
                return new ResponseEntity<>(HttpStatus.CREATED);
            } catch (DataPersistFailedException e) {
                logger.error("Failed to persist order data: {}", orderDTO, e);
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            } catch (Exception e) {
                logger.error("Unexpected error occurred while saving order: {}", orderDTO, e);
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderDetailsDTO> getOrderDetails() {
        return ordersService.getOrderDetails();
    }

}
