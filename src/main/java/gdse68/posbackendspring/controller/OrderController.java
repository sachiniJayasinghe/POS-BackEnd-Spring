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
}


