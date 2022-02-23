package pl.nojman.restaurant_api.Models;

import java.util.List;
import java.util.Objects;

public class Restaurant {
    private Long id;
    private String name;
    private String description;

    private Address address;
    private int addressId;

    private List<Dish> dishes;
    private List<Integer> dishesId;

    public Restaurant() {
    }

    public Restaurant(Long id,
                      String name,
                      String description,
                      Address address,
                      int addressId,
                      List<Dish> dishes,
                      List<Integer> dishesId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.address = address;
        this.addressId = addressId;
        this.dishes = dishes;
        this.dishesId = dishesId;
    }

    public Restaurant(String name,
                      String description,
                      Address address,
                      int addressId,
                      List<Dish> dishes,
                      List<Integer> dishesId) {
        this.name = name;
        this.description = description;
        this.address = address;
        this.addressId = addressId;
        this.dishes = dishes;
        this.dishesId = dishesId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public List<Integer> getDishesId() {
        return dishesId;
    }

    public void setDishesId(List<Integer> dishesId) {
        this.dishesId = dishesId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Restaurant that = (Restaurant) o;
        return addressId == that.addressId && id.equals(that.id) && name.equals(that.name) && description.equals(that.description) && address.equals(that.address) && dishes.equals(that.dishes) && dishesId.equals(that.dishesId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, address, addressId, dishes, dishesId);
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", address=" + address +
                ", addressId=" + addressId +
                ", dishes=" + dishes +
                ", dishesId=" + dishesId +
                '}';
    }
}
