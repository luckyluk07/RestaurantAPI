package pl.nojman.restaurant_api.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.nojman.restaurant_api.Models.Dish;
import pl.nojman.restaurant_api.Models.Restaurant;

import java.util.List;
import java.util.Optional;

@Repository
public interface IDishRepository extends JpaRepository<Dish, Long> {
    List<Dish> findAllByRestaurant(Restaurant restaurant);

    Optional<Dish> findByIdAndRestaurant(Long id, Restaurant restaurant);

    @Modifying
    @Query("update Dish d set d.description = :description, d.price = :price where d.name = :name")
    void updateDish(@Param("name") String name, @Param("description") String description, @Param("price") double price);
}
