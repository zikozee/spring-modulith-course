package com.zee.springmodulithcourse.order;

import com.zee.springmodulithcourse.order.dto.CompleteOrder;
import com.zee.springmodulithcourse.order.dto.CompleteOrderResponse;
import com.zee.springmodulithcourse.order.dto.OrderDto;
import com.zee.springmodulithcourse.order.dto.OrderResponseDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 30 May, 2024
 */

@RestController @RequestMapping(path = "order")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<OrderResponseDto> createOrder(@RequestBody @Valid OrderDto orderDto) {
        return new ResponseEntity<>(orderService.createOrder(orderDto), HttpStatus.OK);
    }

    @PostMapping(path = "complete")
    public ResponseEntity<CompleteOrderResponse> completeOrder(@RequestBody @Valid CompleteOrder completeOrder) {
        return new ResponseEntity<>(orderService.completePayment(completeOrder), HttpStatus.OK);
    }
}
