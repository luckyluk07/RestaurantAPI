package pl.nojman.restaurant_api.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.nojman.restaurant_api.Models.Restaurant;


@Repository
public interface IRestaurantRepository extends JpaRepository<Restaurant, Long> {

    @Modifying
    @Query("update restaurant r set r.description = :description where r.name = :name")
    void updateRestaurant(@Param("name") String name, @Param("description") String description);

}
