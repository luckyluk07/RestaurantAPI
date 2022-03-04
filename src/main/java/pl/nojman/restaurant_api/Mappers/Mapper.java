package pl.nojman.restaurant_api.Mappers;

import org.springframework.stereotype.Component;
import pl.nojman.restaurant_api.Dtos.RestaurantDto;
import pl.nojman.restaurant_api.Models.Address;
import pl.nojman.restaurant_api.Models.Restaurant;


@Component
public class Mapper {

    public RestaurantDto restaurantModelToDto(Restaurant restaurant) {
        String name = restaurant.getName();
        String description = restaurant.getDescription();
        String city = restaurant.getAddress().getCity();
        String street = restaurant.getAddress().getStreet();
        String number = restaurant.getAddress().getNumber();
        return new RestaurantDto(name, description, city, street, number);
    }

    public Restaurant dtoToRestaurantModel(RestaurantDto dto) {
        String name = dto.getName();
        String description = dto.getDescription();
        Address address = new Address(dto.getCity(), dto.getStreet(), dto.getNumber());
        Long addressId = 0L;
        return new Restaurant(name, description, address, null);
    }

}
