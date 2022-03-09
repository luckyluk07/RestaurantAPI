package pl.nojman.restaurant_api.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.nojman.restaurant_api.Models.Address;
import pl.nojman.restaurant_api.Models.Dish;
import pl.nojman.restaurant_api.Models.Restaurant;
import pl.nojman.restaurant_api.Repositories.IAddressRepository;
import pl.nojman.restaurant_api.Services.DishService;
import pl.nojman.restaurant_api.Services.RestaurantService;

import javax.annotation.PostConstruct;

@Component
public class Initializer {
    private final RestaurantService restaurantService;
    private final DishService dishService;
    private final IAddressRepository addressRepository;

    @Autowired
    public Initializer(RestaurantService restaurantService,
                       DishService dishService,
                       IAddressRepository addressRepository) {
        this.restaurantService = restaurantService;
        this.dishService = dishService;
        this.addressRepository = addressRepository;
    }

    @PostConstruct
    public void init() {
        Address address1 = Address.builder()
                .city("Lubawa")
                .street("Królowej Jadwigi")
                .number("6")
                .build();

        Address address2 = Address.builder()
                        .city("Gdansk")
                        .street("Krynicka")
                        .number("7")
                        .build();


        Address address3 = Address.builder()
                .city("Kazanice")
                .street("Kazanice")
                .number("5")
                .build();

        this.addressRepository.save(address1);
        this.addressRepository.save(address2);
        this.addressRepository.save(address3);

        Restaurant restaurant1 = Restaurant.builder()
                .name("name1")
                .description("description1")
                .address(address1)
                .build();

        Restaurant restaurant2 = Restaurant.builder()
                .name("name2")
                .description("description2")
                .address(address2)
                .build();

        Restaurant restaurant3 = Restaurant.builder()
                .name("name3")
                .description("description3")
                .address(address3)
                .build();

        this.restaurantService.createRestaurant(restaurant1);
        this.restaurantService.createRestaurant(restaurant2);
        this.restaurantService.createRestaurant(restaurant3);

        Dish dish1 = Dish.builder()
                .name("dish1")
                .description("description1")
                .price(10.0)
                .restaurant(restaurant1)
                .build();

        Dish dish2 = Dish.builder()
                .name("dish2")
                .description("description2")
                .price(20.0)
                .restaurant(restaurant2)
                .build();

        Dish dish3 = Dish.builder()
                .name("dish3")
                .description("description3")
                .price(30.0)
                .restaurant(restaurant3)
                .build();

        this.dishService.create(dish1);
        this.dishService.create(dish2);
        this.dishService.create(dish3);
    }
}
