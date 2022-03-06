package pl.nojman.restaurant_api.Models;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity(name = "restaurant")
@Table(name = "RESTAURANTS")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //@Column(name = "RESTAURANT_NAME", nullable = false, unique = true)
    private String name;
    private String description;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.REMOVE)
    private List<Dish> dishes;

    public Restaurant() {
    }

    public Restaurant(Long id,
                      String name,
                      String description,
                      Address address,
                      List<Dish> dishes) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.address = address;
        this.dishes = dishes;
    }

    public Restaurant(String name,
                      String description,
                      Address address,
                      List<Dish> dishes) {
        this.name = name;
        this.description = description;
        this.address = address;;
        this.dishes = dishes;;
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

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Restaurant that = (Restaurant) o;
        return id.equals(that.id) && name.equals(that.name) && description.equals(that.description) && address.equals(that.address) && dishes.equals(that.dishes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, address, dishes);
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", address=" + address +
                ", dishes=" + dishes +
                '}';
    }
}
