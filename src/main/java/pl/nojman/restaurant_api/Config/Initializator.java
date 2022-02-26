package pl.nojman.restaurant_api.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.nojman.restaurant_api.Models.Address;
import pl.nojman.restaurant_api.Models.Dish;
import pl.nojman.restaurant_api.Models.Restaurant;
import pl.nojman.restaurant_api.Services.DishService;
import pl.nojman.restaurant_api.Services.RestaurantService;

import javax.annotation.PostConstruct;

@Component
public class Initializator {
    private RestaurantService restaurantService;
    private DishService dishService;

    @Autowired
    public Initializator(RestaurantService restaurantService, DishService dishService) {
        this.restaurantService = restaurantService;
        this.dishService = dishService;
    }

    @PostConstruct
    public void init() {
        Address address1 = new Address(
                1L,
                "Lubawa",
                "Krolowej Jadwigi",
                "6"
        );

        Address address2 = new Address(
                2L,
                "Gdansk",
                "Krynicka",
                "7"
        );

        Address address3 = new Address(
                3L,
                "Kazanice",
                "Polna",
                "5"
        );

        Restaurant restaurant1 = new Restaurant(
                1L,
                "name1",
                "description1",
                address1,
                address1.getId(),
                null,
                null
        );

        Restaurant restaurant2 = new Restaurant(
                2L,
                "name2",
                "description2",
                address2,
                address2.getId(),
                null,
                null
        );

        Restaurant restaurant3 = new Restaurant(
                3L,
                "name3",
                "description3",
                address3,
                address3.getId(),
                null,
                null
        );

        this.restaurantService.createRestaurant(restaurant1);
        this.restaurantService.createRestaurant(restaurant2);
        this.restaurantService.createRestaurant(restaurant3);

        Dish dish1 = new Dish(
                1L,
                "dish1",
                "description1",
                10.0,
                restaurant1,
                restaurant1.getId()
        );
        Dish dish2 = new Dish(
                2L,
                "dish2",
                "description2",
                20.0,
                restaurant2,
                restaurant2.getId()
        );
        Dish dish3 = new Dish(
                3L,
                "dish3",
                "description3",
                30.0,
                restaurant3,
                restaurant3.getId()
        );

        this.dishService.create(dish1);
        this.dishService.create(dish2);
        this.dishService.create(dish3);
    }
}
