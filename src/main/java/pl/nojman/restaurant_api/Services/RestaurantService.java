package pl.nojman.restaurant_api.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import pl.nojman.restaurant_api.Dtos.RestaurantDto;
import pl.nojman.restaurant_api.Mappers.Mapper;
import pl.nojman.restaurant_api.Models.Address;
import pl.nojman.restaurant_api.Models.Restaurant;
import pl.nojman.restaurant_api.Repositories.IAddressRepository;
import pl.nojman.restaurant_api.Repositories.IRestaurantRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {

    private IRestaurantRepository repository;
    private IAddressRepository addressRepository;
    private Mapper mapper;

    @Autowired
    public RestaurantService(IRestaurantRepository repository,
                             IAddressRepository addressRepository ,
                             Mapper mapper) {
        this.repository = repository;
        this.addressRepository = addressRepository;
        this.mapper = mapper;
    }

    public List<Restaurant> getAllRestaurant() {
        return this.repository.findAll();
    }

    public Optional<Restaurant> getRestaurant(Long id) {
        return this.repository.findById(id);
    }

    public Restaurant createRestaurant(RestaurantDto restaurantDto) {
        Pair<Restaurant, Address> restaurantAddressPair = this.mapper.dtoToRestaurantModel(restaurantDto);
        this.addressRepository.save(restaurantAddressPair.getSecond());
        return this.repository.save(restaurantAddressPair.getFirst());
    }

    public Restaurant createRestaurant(Restaurant restaurant) {
        return this.repository.save(restaurant);
    }

    public void deleteRestaurant(Long id) {
        this.repository.deleteById(id);
    }

    public void updateRestaurant(RestaurantDto restaurantDto, Long id) {
        if (getRestaurant(id).isPresent()) {
            Pair<Restaurant, Address> restaurantAddressPair = this.mapper.dtoToRestaurantModel(restaurantDto);
            this.addressRepository.save(restaurantAddressPair.getSecond());
            this.repository.save( restaurantAddressPair.getFirst());
        }
    }
}
