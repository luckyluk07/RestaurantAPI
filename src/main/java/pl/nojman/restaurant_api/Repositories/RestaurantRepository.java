package pl.nojman.restaurant_api.Repositories;

import org.springframework.stereotype.Repository;
import pl.nojman.restaurant_api.Dtos.RestaurantDto;
import pl.nojman.restaurant_api.Models.Address;
import pl.nojman.restaurant_api.Models.Restaurant;

import java.util.*;

@Repository
public class RestaurantRepository {
    private Set<Restaurant> restaurants = new HashSet<Restaurant>();
    private Long idCounter = 0L;

    public List<Restaurant> getAll() {
        return new ArrayList<>(restaurants);
    }

    public Optional<Restaurant> get(Long id) {
        Restaurant restaurant = null;
        for (var tmp : restaurants) {
            if (tmp.getId() == id) {
                restaurant = tmp;
            }
        }
        return Optional.ofNullable(restaurant);
    }

    public boolean delete(Long id) {
        Restaurant restaurant = restaurants.stream()
                .filter(r -> r.getId() == id)
                .findFirst()
                .get();
        if (restaurants.contains(restaurant)) {
            restaurants.remove(restaurant);
            return true;
        }
        return false;
    }

    public boolean update(RestaurantDto dto, Restaurant restaurant) {
        this.restaurants.remove(restaurant);
        this.restaurants.add(new Restaurant(
                restaurant.getId(),
                dto.getName(),
                dto.getDescription(),
                new Address(dto.getCity(), dto.getStreet(), dto.getNumber()),
                null
        ));
        return true;
    }

    public Restaurant create(Restaurant restaurant) {
        restaurant.setId(++idCounter);
        restaurants.add(restaurant);
        return restaurant;
    }
}
