package pl.nojman.restaurant_api.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.nojman.restaurant_api.Models.Dish;
import pl.nojman.restaurant_api.Models.Restaurant;
import pl.nojman.restaurant_api.Services.DishService;
import pl.nojman.restaurant_api.Services.RestaurantService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/restaurants/{restaurantId}/dishes")
public class DishController {

    private DishService service;
    private RestaurantService restaurantService;

    @Autowired
    public DishController(DishService service, RestaurantService restaurantService) {
        this.service = service;
        this.restaurantService = restaurantService;
    }

    @GetMapping()
    public List<Dish> getDishes(@PathVariable long restaurantId) {
        Optional<Restaurant> restaurant = restaurantService.getRestaurant(restaurantId);
        if (restaurant.isPresent()) {
            return this.service.findAll(restaurantId);
        }
        return null;
    }

    @GetMapping("/{dishId}")
    public Dish getDish(@PathVariable long restaurantId, @PathVariable long dishId) {
        return this.service.find(restaurantId, dishId);
    }

    @PostMapping()
    public void create(@PathVariable long restaurantId, @RequestBody Dish dish) {
        this.service.create(dish);
    }

    @DeleteMapping("/{dishId}")
    public void delete(@PathVariable long restaurantId, @PathVariable long dishId) {
        this.service.delete(dishId);
    }

    @PutMapping("/{dishId}")
    public void update(@PathVariable long restaurantId, @PathVariable long dishId, @RequestBody Dish dish) {
        this.service.update(dish);
    }

}
