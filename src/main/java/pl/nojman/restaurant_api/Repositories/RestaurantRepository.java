package pl.nojman.restaurant_api.Repositories;

import pl.nojman.restaurant_api.Models.Restaurant;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RestaurantRepository {
    private Set<Restaurant> restaurants = new HashSet<>();

    public List<Restaurant> getAll() {
        return new ArrayList<>(restaurants);
    }

    public Restaurant get(Long id) {
        return restaurants.stream()
                .filter(restaurant -> restaurant.getId() == id)
                .findFirst()
                .get();
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

    public void create(Restaurant restaurant) {
        restaurants.add(restaurant);
    }
}
