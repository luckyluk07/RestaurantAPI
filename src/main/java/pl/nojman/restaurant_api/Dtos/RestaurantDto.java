package pl.nojman.restaurant_api.Dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RestaurantDto {
    private final String name;
    private final String description;

    private final String city;
    private final String street;
    private final String number;
}
