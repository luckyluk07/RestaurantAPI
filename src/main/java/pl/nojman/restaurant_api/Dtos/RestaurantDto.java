package pl.nojman.restaurant_api.Dtos;

import pl.nojman.restaurant_api.Models.Restaurant;

public class RestaurantDto {
    private final String name;
    private final String description;

    private final String city;
    private final String street;
    private final String number;

    public RestaurantDto(String name, String description, String city, String street, String number) {
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
}
