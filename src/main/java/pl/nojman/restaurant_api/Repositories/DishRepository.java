package pl.nojman.restaurant_api.Repositories;

import org.springframework.stereotype.Repository;
import pl.nojman.restaurant_api.Models.Dish;

import java.util.*;

@Repository
public class DishRepository {

    private Set<Dish> dishes = new HashSet<>();

    public List<Dish> getAll() {
        return new ArrayList<>(dishes);
    }

    public Dish get(Long id) {
        return dishes.stream()
                .filter(dish -> dish.getId() == id)
                .findFirst()
                .get();
    }

    public boolean delete(Long id) {
        Dish dish = dishes.stream()
                .filter(d -> d.getId() == id)
                .findFirst()
                .get();
        if (dishes.contains(dish)) {
            dishes.remove(dish);
            return true;
        }
        return false;
    }

    public boolean update(Dish dish) {
        Dish existingDish = dishes.stream()
                .filter(d -> d.getId() == dish.getId())
                .findFirst()
                .get();
        if (dishes.contains(existingDish)) {
            existingDish = dish;
            return true;
        }
        return false;
    }

    public void create(Dish dish) {
        dishes.add(dish);
    }
}
