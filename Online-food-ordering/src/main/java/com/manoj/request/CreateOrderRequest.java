package com.manoj.request;

import com.manoj.model.Address;
import lombok.Data;

@Data
public class CreateOrderRequest {

    private Long restaurantId;
    private Address deliveryAddress;
}
