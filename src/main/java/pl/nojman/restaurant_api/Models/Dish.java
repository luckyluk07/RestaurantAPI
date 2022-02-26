package pl.nojman.restaurant_api.Models;

import java.util.Objects;

public class Dish {
    private Long id;
    private String name;
    private String description;
    private Double price;

    private Restaurant restaurant;
    private Long restaurantId;

    public Dish() {
    }

    public Dish(Long id, String name, String description, Double price, Restaurant restaurant, Long restaurantId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.restaurant = restaurant;
        this.restaurantId = restaurantId;
    }

    public Dish(String name, String description, Double price, Restaurant restaurant, Long restaurantId) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.restaurant = restaurant;
        this.restaurantId = restaurantId;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dish dish = (Dish) o;
        return id.equals(dish.id) && name.equals(dish.name) && description.equals(dish.description) && price.equals(dish.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, price);
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
