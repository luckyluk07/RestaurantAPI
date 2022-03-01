package pl.nojman.restaurant_api.Dtos;

import pl.nojman.restaurant_api.Models.Restaurant;

import java.util.Objects;

public class RestaurantGetDto {
    private final String name;
    private final String description;

    private final String city;
    private final String street;
    private final String number;

    public RestaurantGetDto(String name, String description, String city, String street, String number) {
        this.name = name;
        this.description = description;
        this.city = city;
        this.street = street;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getNumber() {
        return number;
    }

    public static RestaurantGetDto entityToDto(Restaurant restaurant) {
        return new RestaurantGetDto(
                restaurant.getName(),
                restaurant.getDescription(),
                restaurant.getAddress().getCity(),
                restaurant.getAddress().getStreet(),
                restaurant.getAddress().getNumber()
        );
    }
}
