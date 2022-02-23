package pl.nojman.restaurant_api.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.nojman.restaurant_api.Models.Dish;

import java.util.List;

@RestController
@RequestMapping("/api/dishes")
public class DishController {

    @GetMapping()
    public List<Dish> getDishes() {
        return List.of(
                new Dish(1L,"name1","desc1",(double) 10),
                new Dish(2L,"name2","desc2",(double) 20)
        );
    }

    @GetMapping("/{dishId}")
    public Dish getDish(@PathVariable int dishId) {
        return new Dish(1L, "name1", "desc1", (double) 10);
    }

}
