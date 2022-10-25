package homework;

import java.util.*;
// class Order
// поля
// поле UUID orderUuid
// поле Map<Item, Integer> itemsMap

// конструкторы
// () по умолчанию сама создат

// методы
// getter/setter/equals/hashcode/toString
public class Order {
    // зделать без конструктара посматреть
    private static int counter = 1;

    private final int id;
    //private final UUID orderUuid;
    private final List<Item> items;

    public Order() {
        id = counter++;
        //orderUuid = UUID.randomUUID();
        items = new ArrayList<>();
    }

    public List<Item> getItems() {
        return items;
    }

//    public void addItem(Item item) {
//        Integer currentItemsCount = items.get(item);
//        if (currentItemsCount == null) {
//            items.put(item, 1);
//        } else {
//            items.put(item, currentItemsCount + 1);
//        }
//        //map.put(item, map.get(item) + 1); // get он по имени ключа берёт значени ключа
//    }

//    public void addItem(ItemType type, double price, int amount) {
//        for (int i = 0; i < amount; i++) {
//            addItem(new Item(type, price));
//        }
//    }

//    public boolean removeItem(Item item) {
//        if (items.containsKey(item)) {
//            items.remove(item);
//            return true;
//        }
//        return false;
//    }

    public void addItem(Item item) {
        items.add(item);
    }

//    public void addItem(ItemType type, double price, int amount) {
//        for (int i = 0; i < amount; i++) {
//            items.add(new Item(type, price));
//        }
//    }

    public double getTotal(){
        return items.stream()
                .map(Item::getPrice)
                .reduce(0D,(Double x, Double y)->x+y);
    }

    public void addItems(List<Item> itemList) {
        items.addAll(itemList);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", items=" + items +
                '}';
    }
}
