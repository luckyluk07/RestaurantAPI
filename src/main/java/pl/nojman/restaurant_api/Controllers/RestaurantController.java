package pl.nojman.restaurant_api.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.nojman.restaurant_api.Models.Restaurant;
import pl.nojman.restaurant_api.Services.RestaurantService;

import java.util.List;

@RestController
@RequestMapping("api/restaurants")
public class RestaurantController {

    private RestaurantService service;

    @Autowired
    public RestaurantController(RestaurantService service) {
        this.service = service;
    }

    @GetMapping()
    public List<Restaurant> findAll() {
        return this.service.getAllRestaurant();
    }

    @GetMapping("/{id}")
    public Restaurant find(@PathVariable Long id) {
        return this.service.getRestaurant(id);
    }

    @PostMapping()
    public void create(@RequestBody Restaurant restaurant) {
        this.service.createRestaurant(restaurant);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.service.deleteRestaurant(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Restaurant restaurant) {
        this.service.updateRestaurant(restaurant);
    }
}
