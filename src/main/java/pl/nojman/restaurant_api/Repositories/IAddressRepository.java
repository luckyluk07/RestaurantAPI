package pl.nojman.restaurant_api.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.nojman.restaurant_api.Models.Address;

@Repository
public interface IAddressRepository extends JpaRepository<Address, Long> {
}
