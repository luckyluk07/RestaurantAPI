package pl.nojman.restaurant_api.Controllers;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import pl.nojman.restaurant_api.Models.Restaurant;
import pl.nojman.restaurant_api.Services.RestaurantService;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<Restaurant> find(@PathVariable Long id) {
        Optional<Restaurant> restaurant = this.service.getRestaurant(id);
        if (restaurant.isPresent()) {
            return ResponseEntity.ok(restaurant.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping()
    public ResponseEntity<Void> create(@RequestBody Restaurant restaurant, UriComponentsBuilder builder) {
        Restaurant tmpRestaurant = this.service.createRestaurant(restaurant);
        return ResponseEntity.created(builder.pathSegment("api", "restaurants", "{id}").buildAndExpand(tmpRestaurant.getId()).toUri()).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (this.service.deleteRestaurant(id)) {
            return ResponseEntity.accepted().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody Restaurant restaurant) {
        if (this.service.updateRestaurant(restaurant)) {
            return ResponseEntity.accepted().build();
        }
        return ResponseEntity.notFound().build();
    }
}
