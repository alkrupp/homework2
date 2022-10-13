package homework;

import java.util.List;
import java.util.Objects;
import java.util.Set;
// class Stoke
// поля
// String name
// List<Item> itemsList
// Set<Order> orders

// конструкторы
// (String name)

// методы
//getter/setter/toString

public class Stoke {

    private String name;

    public List<Item> itemsList;

    public Set<Order> orders;

    public Stoke(String name, List<Item> itemsList, Set<Order> orders) {
        this.name = name;
        this.itemsList = itemsList;
        this.orders = orders;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getItemsList() {
        return itemsList;
    }

    public void setItemsList(List<Item> itemsList) {
        this.itemsList = itemsList;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }


    @Override
    public String toString() {
        return "Stoke{" +
                "name='" + name + '\'' +
                ", itemsList=" + itemsList +
                ", orders=" + orders +
                '}';
    }
}
