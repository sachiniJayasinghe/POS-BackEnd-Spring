package gdse68.posbackendspring.controller;

import gdse68.posbackendspring.customObj.OrdersResponse;
import gdse68.posbackendspring.dto.OrdersDTO;
import gdse68.posbackendspring.exception.DataPersistFailedException;
import gdse68.posbackendspring.exception.OrderNotFound;
import gdse68.posbackendspring.service.OrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    @Autowired
    private final OrdersService ordersService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createOrders(@RequestBody OrdersDTO order) {
        if (order == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            try {
                ordersService.saveOrder(order);
                return new ResponseEntity<>(HttpStatus.CREATED);
            } catch (DataPersistFailedException e) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
    @PatchMapping(value = "/{orderId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateOrder(@PathVariable ("orderId") String orderId, @RequestBody OrdersDTO order) {
        try {
            if (order == null && (orderId == null || order.equals(""))) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            ordersService.updateOrder(orderId, order);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (OrderNotFound e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value ="/{orderId}" )
    public ResponseEntity<Void> deleteOrders(@PathVariable ("orderId") String orderId) {
        try {
            ordersService.deleteOrder(orderId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (OrderNotFound e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(value = "/{orderId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public OrdersResponse getSelectedOrder(@PathVariable ("orderId") String orderId)  {
        return ordersService.getSelectedOrder(orderId);
    }
    @GetMapping(value = "allorder", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrdersDTO> getAllOrders(){
        return ordersService.getAllOrder();
    }

    }
