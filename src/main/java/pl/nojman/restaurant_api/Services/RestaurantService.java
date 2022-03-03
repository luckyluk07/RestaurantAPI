package pl.nojman.restaurant_api.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.nojman.restaurant_api.Dtos.RestaurantDto;
import pl.nojman.restaurant_api.Mappers.Mapper;
import pl.nojman.restaurant_api.Models.Restaurant;
import pl.nojman.restaurant_api.Repositories.RestaurantRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {

    private RestaurantRepository repository;
    private Mapper mapper;

    @Autowired
    public RestaurantService(RestaurantRepository repository, Mapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<Restaurant> getAllRestaurant() {
        return this.repository.getAll();
    }

    public Optional<Restaurant> getRestaurant(Long id) {
        return this.repository.get(id);
    }

    public Restaurant createRestaurant(RestaurantDto restaurantDto) {
        Restaurant restaurantToCreate = this.mapper.dtoToRestaurantModel(restaurantDto);
        return this.repository.create(restaurantToCreate);
    }

    public Restaurant createRestaurant(Restaurant restaurant) {
        return this.repository.create(restaurant);
    }

    public boolean deleteRestaurant(Long id) {
        return this.repository.delete(id);
    }

    public boolean updateRestaurant(RestaurantDto restaurantDto) {
        Restaurant restaurantToUpdate = this.mapper.dtoToRestaurantModel(restaurantDto);
        return this.repository.update(restaurantToUpdate);
    }
}
