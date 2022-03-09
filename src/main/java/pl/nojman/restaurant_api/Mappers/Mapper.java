package pl.nojman.restaurant_api.Mappers;

import org.springframework.data.util.Pair;
import org.springframework.stereotype.Component;
import pl.nojman.restaurant_api.Dtos.DishDto;
import pl.nojman.restaurant_api.Dtos.RestaurantDto;
import pl.nojman.restaurant_api.Models.Address;
import pl.nojman.restaurant_api.Models.Dish;
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

    public Pair<Restaurant, Address> dtoToRestaurantModel(RestaurantDto dto) {
        String name = dto.getName();
        String description = dto.getDescription();
        Address address = Address.builder()
                .city(dto.getCity())
                .street(dto.getStreet())
                .number(dto.getNumber())
                .build();
        return Pair.of(Restaurant.builder().name(name).description(description).address(address).build(), address);
    }

    public DishDto dishModelToDto(Dish dish) {
        String name = dish.getName();
        String description = dish.getDescription();
        Double prize = dish.getPrice();
        return new DishDto(name, description, prize);
    }

    public Dish dtoToDishModel(DishDto dto, Restaurant restaurant) {
        String name = dto.getName();
        String description = dto.getDescription();
        Double prize = dto.getPrice();
        return Dish.builder()
                    .name(name)
                    .description(description)
                    .price(prize)
                    .restaurant(restaurant).
                    build();
        }

}
