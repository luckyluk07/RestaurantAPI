package pl.nojman.restaurant_api.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.nojman.restaurant_api.Models.Dish;
import pl.nojman.restaurant_api.Models.Restaurant;
import pl.nojman.restaurant_api.Repositories.IDishRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DishService {

    private RestaurantService restaurantService;
    private IDishRepository repository;

    @Autowired
    public DishService(IDishRepository repository, RestaurantService restaurantService) {
        this.repository = repository;
        this.restaurantService = restaurantService;
    }

    public List<Dish> findAll() {
        return this.repository.findAll();
    }

    public List<Dish> findAll(Long restaurantId) {
        Restaurant restaurant = restaurantService.getRestaurant(restaurantId).get();
        return this.repository.findAllByRestaurant(restaurant);
    }

    public Optional<Dish> find(Long restaurantId, Long id) {
        Restaurant restaurant = restaurantService.getRestaurant(restaurantId).get();
        return this.repository.findByIdAndRestaurant(id, restaurant);
    }

    public void create(Dish dish) {
        this.repository.save(dish);
    }

    public void delete(Long id) {
        this.repository.deleteById(id);
    }

    public void update(Dish dish) {
        this.repository.save(dish);
    }

}
