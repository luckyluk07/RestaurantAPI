package pl.nojman.restaurant_api.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.nojman.restaurant_api.Models.Dish;
import pl.nojman.restaurant_api.Services.DishService;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants/{restaurantId}/dishes")
public class DishController {

    private DishService service;

    @Autowired
    public DishController(DishService service) {
        this.service = service;
    }

    @GetMapping()
    public List<Dish> getDishes(@PathVariable long restaurantId) {
        return this.service.findAll();
    }

    @GetMapping("/{dishId}")
    public Dish getDish(@PathVariable long restaurantId, @PathVariable long dishId) {
        return this.service.find(dishId);
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
