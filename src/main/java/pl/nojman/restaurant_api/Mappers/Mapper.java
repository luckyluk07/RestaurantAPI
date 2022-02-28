package pl.nojman.restaurant_api.Mappers;

import org.springframework.stereotype.Component;
import pl.nojman.restaurant_api.Dtos.RestaurantGetDto;
import pl.nojman.restaurant_api.Models.Restaurant;

@Component
public class Mapper {

    public RestaurantGetDto toRestaurantGetDto(Restaurant restaurant) {
        String name = restaurant.getName();
        String description = restaurant.getDescription();
        String city = restaurant.getAddress().getCity();
        String street = restaurant.getAddress().getStreet();
        String number = restaurant.getAddress().getNumber();
        return new RestaurantGetDto(name, description, city, street, number);
    }

}
