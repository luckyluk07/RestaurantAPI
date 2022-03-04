package pl.nojman.restaurant_api.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.nojman.restaurant_api.Models.Dish;
import pl.nojman.restaurant_api.Models.Restaurant;

import java.util.List;
import java.util.Optional;

@Repository
public interface IDishRepository extends JpaRepository<Dish, Long> {
    List<Dish> findAllByRestaurant(Restaurant restaurant);

    Optional<Dish> findByIdAndRestaurant(Long id, Restaurant restaurant);
}
