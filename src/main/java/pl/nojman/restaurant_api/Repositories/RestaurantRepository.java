package pl.nojman.restaurant_api.Repositories;

import org.springframework.stereotype.Repository;
import pl.nojman.restaurant_api.Models.Restaurant;

import java.util.*;

@Repository
public class RestaurantRepository {
    private Set<Restaurant> restaurants = new HashSet<Restaurant>();

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

    public boolean update(Restaurant restaurant) {
        Restaurant existingRestaurant = restaurants.stream()
                .filter(r -> r.getId() == restaurant.getId())
                .findFirst()
                .get();
        if (restaurants.contains(existingRestaurant)) {
            existingRestaurant = restaurant;
            return true;
        }
        return false;
    }

    public Restaurant create(Restaurant restaurant) {
        restaurants.add(restaurant);
        return restaurant;
    }
}
