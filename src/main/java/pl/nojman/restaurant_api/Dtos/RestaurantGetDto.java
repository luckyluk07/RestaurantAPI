package pl.nojman.restaurant_api.Dtos;

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
}
