package pl.nojman.restaurant_api.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.nojman.restaurant_api.Models.Restaurant;
import pl.nojman.restaurant_api.Repositories.RestaurantRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {

    private RestaurantRepository repository;

    @Autowired
    public RestaurantService(RestaurantRepository repository) {
        this.repository = repository;
    }

    public List<Restaurant> getAllRestaurant() {
        return this.repository.getAll();
    }

    public Optional<Restaurant> getRestaurant(Long id) {
        return Optional.ofNullable(this.repository.get(id));
    }

    public Restaurant createRestaurant(Restaurant restaurant) {
        return this.repository.create(restaurant);
    }

    public boolean deleteRestaurant(Long id) {
        return this.repository.delete(id);
    }

    public boolean updateRestaurant(Restaurant restaurant) {
        return this.repository.update(restaurant);
    }
}
