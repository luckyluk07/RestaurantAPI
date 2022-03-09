package pl.nojman.restaurant_api.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.nojman.restaurant_api.Dtos.DishDto;
import pl.nojman.restaurant_api.Mappers.Mapper;
import pl.nojman.restaurant_api.Models.Dish;
import pl.nojman.restaurant_api.Models.Restaurant;
import pl.nojman.restaurant_api.Repositories.IDishRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DishService {

    private RestaurantService restaurantService;
    private IDishRepository repository;
    private Mapper mapper;

    @Autowired
    public DishService(IDishRepository repository, RestaurantService restaurantService, Mapper mapper) {
        this.repository = repository;
        this.restaurantService = restaurantService;
        this.mapper = mapper;
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

    public Dish create(Dish dish) {
        return this.repository.save(dish);
    }

    public Dish create(DishDto dto, Restaurant restaurant) {
        Dish dish = this.mapper.dtoToDishModel(dto, restaurant);
        return this.repository.save(dish);
    }

    public void delete(Long id) {
        this.repository.deleteById(id);
    }

    @Transactional
    public void update(String dishName, DishDto dishDto) {
        this.repository.updateDish(dishName, dishDto.getDescription(), dishDto.getPrice());
    }

}
