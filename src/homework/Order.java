package homework;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
// class Order
// поля
// поле UUID orderUuid
// поле Map<Item, Integer> itemsMap

// конструкторы
// () по умолчанию сама создат

// методы
// getter/setter/equals/hashcode/toString
public class Order {
    private UUID orderUuid = UUID.randomUUID();

    public Map<Item, Integer> MAP = new HashMap<>();

    public Order(UUID orderUuid, Map<Item, Integer> MAP) {
        this.orderUuid = orderUuid;
        this.MAP = MAP;
    }


    public UUID getOrderUuid() {
        return orderUuid;
    }

    public void setOrderUuid(UUID orderUuid) {
        this.orderUuid = orderUuid;
    }

    public Map<Item, Integer> getMAP() {
        return MAP;
    }

    public void setMAP(Map<Item, Integer> MAP) {
        this.MAP = MAP;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderUuid.equals(order.orderUuid) && MAP.equals(order.MAP);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderUuid, MAP);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderUuid=" + orderUuid +
                ", MAP=" + MAP +
                '}';
    }
}
