package pl.nojman.restaurant_api.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.nojman.restaurant_api.Models.Restaurant;
import pl.nojman.restaurant_api.Repositories.RestaurantRepository;

import java.util.List;

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

    public Restaurant getRestaurant(Long id) {
        return this.repository.get(id);
    }

    public void createRestaurant(Restaurant restaurant) {
        this.repository.create(restaurant);
    }

    public boolean deleteRestaurant(Long id) {
        return this.repository.delete(id);
    }

    public boolean updateRestaurant(Restaurant restaurant) {
        return this.repository.update(restaurant);
    }
}
