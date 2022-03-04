package pl.nojman.restaurant_api.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import pl.nojman.restaurant_api.Dtos.RestaurantDto;
import pl.nojman.restaurant_api.Mappers.Mapper;
import pl.nojman.restaurant_api.Models.Restaurant;
import pl.nojman.restaurant_api.Services.RestaurantService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(
        value = "api/restaurants"
)
public class RestaurantController {

    private RestaurantService service;
    private Mapper mapper;

    @Autowired
    public RestaurantController(RestaurantService service, Mapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping()
    public List<RestaurantDto> findAll() {
        return this.service.getAllRestaurant().stream().map(x -> mapper.restaurantModelToDto(x)).collect(Collectors.toList());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<RestaurantDto> find(@PathVariable Long id) {
        Optional<Restaurant> restaurant = this.service.getRestaurant(id);
        if (restaurant.isPresent()) {
            return ResponseEntity.ok(this.mapper.restaurantModelToDto(restaurant.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping()
    public ResponseEntity<Void> create(@RequestBody RestaurantDto restaurantDto, UriComponentsBuilder builder) {
        Restaurant tmpRestaurant = this.service.createRestaurant(restaurantDto);
        return ResponseEntity.created(builder.pathSegment("api", "restaurants", "{id}").buildAndExpand(tmpRestaurant.getId()).toUri()).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Optional<Restaurant> restaurant = this.service.getRestaurant(id);
        if (restaurant.isPresent()) {
            this.service.deleteRestaurant(id);
            return ResponseEntity.accepted().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody RestaurantDto restaurantDto) {
        Optional<Restaurant> restaurant = this.service.getRestaurant(id);
        if (restaurant.isPresent()) {
            this.service.updateRestaurant(restaurantDto, id);
            return ResponseEntity.accepted().build();
        }
        return ResponseEntity.notFound().build();
    }
}
