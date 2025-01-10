package com.manoj.request;

import lombok.Data;

@Data
public class IngredientItemRequest {

    private String name;
    private Long CategoryId;
    private Long restaurantId;
}
