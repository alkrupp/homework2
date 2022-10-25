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
    private final ItemType type;
    private double price;

    public Item(ItemType type, double price) {
        id = counter++;
        this.type = type;
        this.price = price;
    }

    public ItemType getType() {
        return type;
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
        return id == item.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Item{" +
                " name='" + type + '\'' +
                ", price=" + price +
                '}';
    }
}
