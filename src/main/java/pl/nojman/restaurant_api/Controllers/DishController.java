package pl.nojman.restaurant_api.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import pl.nojman.restaurant_api.Dtos.DishDto;
import pl.nojman.restaurant_api.Mappers.Mapper;
import pl.nojman.restaurant_api.Models.Dish;
import pl.nojman.restaurant_api.Models.Restaurant;
import pl.nojman.restaurant_api.Services.DishService;
import pl.nojman.restaurant_api.Services.RestaurantService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/restaurants/{restaurantId}/dishes")
public class DishController {

    private DishService service;
    private RestaurantService restaurantService;
    private Mapper mapper;

    @Autowired
    public DishController(DishService service,
                          RestaurantService restaurantService,
                          Mapper mapper) {
        this.service = service;
        this.restaurantService = restaurantService;
        this.mapper = mapper;
    }

    @GetMapping()
    public ResponseEntity<List<DishDto>> getDishes(@PathVariable long restaurantId) {
        Optional<Restaurant> restaurant = restaurantService.getRestaurant(restaurantId);
        if (restaurant.isPresent()) {
            return ResponseEntity.ok(this.service.findAll(restaurantId).stream()
                    .map(x -> this.mapper.dishModelToDto(x))
                    .collect(Collectors.toList()));
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{dishId}")
    public ResponseEntity<DishDto> getDish(@PathVariable long restaurantId,
                                           @PathVariable long dishId) {
        Optional<Restaurant> restaurant = this.restaurantService.getRestaurant(restaurantId);
        if (restaurant.isPresent()) {
            Optional<Dish> dish = this.service.find(restaurantId, dishId);
            if (dish.isPresent()) {
                return ResponseEntity.ok(this.mapper.dishModelToDto(dish.get()));
            }
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping()
    public ResponseEntity<Void> create(@PathVariable long restaurantId,
                                       @RequestBody DishDto dishDto, UriComponentsBuilder builder) {
        Optional<Restaurant> restaurant = this.restaurantService.getRestaurant(restaurantId);
        if (restaurant.isPresent()) {
            Dish dish = this.service.create(dishDto, restaurant.get());
            return ResponseEntity.created(builder.pathSegment("api","restaurants","{restaurantId}","dishes", "{dishId}")
                                .buildAndExpand(restaurant.get().getId(),dish.getId())
                                .toUri()).build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{dishId}")
    public ResponseEntity<Void> delete(@PathVariable long restaurantId,
                                       @PathVariable long dishId) {
        Optional<Restaurant> restaurant = this.restaurantService.getRestaurant(restaurantId);
        if (restaurant.isPresent()) {
            Optional<Dish> dish = this.service.find(restaurantId, dishId);
            if (dish.isPresent()) {
                this.service.delete(dishId);
                return ResponseEntity.accepted().build();
            }
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{dishId}")
    public ResponseEntity<Void> update(@PathVariable long restaurantId,
                                       @PathVariable long dishId,
                                       @RequestBody DishDto dishDto) {
        Optional<Restaurant> restaurant = this.restaurantService.getRestaurant(restaurantId);
        if (restaurant.isPresent()) {
            Optional<Dish> dish = this.service.find(restaurantId, dishId);
            if (dish.isPresent()) {
                this.service.update(dish.get().getName(), dishDto);
                return ResponseEntity.accepted().build();
            }
        }
        return ResponseEntity.notFound().build();
    }

}
