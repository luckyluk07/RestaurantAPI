package pl.nojman.restaurant_api.Dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DishDto {
    private String name;
    private String description;
    private Double price;
}
