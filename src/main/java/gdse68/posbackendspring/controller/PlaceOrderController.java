package gdse68.posbackendspring.controller;

import gdse68.posbackendspring.service.OrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/order")
@RequiredArgsConstructor
public class PlaceOrderController {
    @Autowired
    private final OrdersService ordersService;

}
