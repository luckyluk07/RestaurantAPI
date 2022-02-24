package pl.nojman.restaurant_api.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.nojman.restaurant_api.Models.Dish;
import pl.nojman.restaurant_api.Repositories.DishRepository;

import java.util.List;

@Service
public class DishService {

    private DishRepository repository;

    @Autowired
    public DishService(DishRepository repository) {
        this.repository = repository;
    }

    public List<Dish> findAll() {
        return this.repository.getAll();
    }

    public Dish find(Long id) {
        return this.repository.get(id);
    }

    public void create(Dish dish) {
        this.repository.create(dish);
    }

    public boolean delete(Long id) {
        return this.repository.delete(id);
    }

    public boolean update(Dish dish) {
        return this.repository.update(dish);
    }
}
