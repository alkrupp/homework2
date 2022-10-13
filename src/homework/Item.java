package homework;
// class Item
// поля
// поле int id
// поле String name
// поле double price
// поле boolean isInOrder = false;

// конструкторы
// (String name, Double price)


import java.util.Objects;

// методы
// getter/setter/equals/hashcode/toString
public class Item {
    private static int counter = 1;

    private final int id;

    private String name;

    private double price;

    public Item(String name, double price) {
        id = counter++;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Double.compare(item.price, price) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(price);
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
