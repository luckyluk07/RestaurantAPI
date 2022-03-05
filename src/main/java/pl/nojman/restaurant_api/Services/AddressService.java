package pl.nojman.restaurant_api.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.nojman.restaurant_api.Models.Address;
import pl.nojman.restaurant_api.Repositories.AddressRepository;

@Service
public class AddressService {

    private AddressRepository repository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.repository = addressRepository;
    }

    public void addAddress(Address address) {
        this.repository.save(address);
    }
}
