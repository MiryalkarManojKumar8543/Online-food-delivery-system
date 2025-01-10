package com.manoj.controller;

import com.manoj.model.IngredientCategory;
import com.manoj.model.IngredientsItem;
import com.manoj.model.User;
import com.manoj.request.IngredientCategoryRequest;
import com.manoj.request.IngredientItemRequest;
import com.manoj.service.IngredientsService;
import com.manoj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/ingredients")
public class IngredientController {

    @Autowired
    private IngredientsService ingredientsService;

    @Autowired
    private UserService userService;

    @PostMapping("/category")
    public ResponseEntity<IngredientCategory> createIngredientCategory(@RequestBody IngredientCategoryRequest request) throws Exception {
        IngredientCategory item = ingredientsService.createIngredientCategory(request.getName(), request.getRestaurantId());
        return new ResponseEntity<>(item, HttpStatus.CREATED);
    }

    @PostMapping
    public ResponseEntity<IngredientsItem> createIngredientItem(@RequestBody IngredientItemRequest request) throws Exception {
        IngredientsItem item = ingredientsService.createIngredientsItem(request.getRestaurantId(),request.getName(), request.getCategoryId());
        return new ResponseEntity<>(item, HttpStatus.CREATED);
    }

    @PutMapping("/{id}/stock")
    public ResponseEntity<IngredientsItem> updateIngredientStock(@PathVariable Long id) throws Exception {
        IngredientsItem item = ingredientsService.updateStock(id);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    @GetMapping("/restaurant/{id}")
    public ResponseEntity<List<IngredientsItem>> getRestaurantIngredients(@PathVariable Long id) throws Exception {
        List<IngredientsItem> items = ingredientsService.findRestaurantsIngredients(id);
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @GetMapping("/restaurant/{id}/category")
    public ResponseEntity<List<IngredientCategory>> getRestaurantIngredientCategory(@PathVariable Long id) throws Exception {
        List<IngredientCategory> categories = ingredientsService.findIngredientCategoryByRestaurantId(id);
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
}
