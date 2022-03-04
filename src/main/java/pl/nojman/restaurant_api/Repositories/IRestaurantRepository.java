package pl.nojman.restaurant_api.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.nojman.restaurant_api.Models.Restaurant;

@Repository
public interface IRestaurantRepository extends JpaRepository<Restaurant, Long> {
}
