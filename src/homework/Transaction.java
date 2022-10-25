package homework;

import java.util.*;

public class Transaction {
    private static int counter = 1;

    private final int id;
    private final List<Item> items;
    // Set<Item>
    private final ItemType type;
    private final int amount;
    private final Order transactionOrder;

    public Transaction(List<Item> items, ItemType type, Order transactionOrder, int amount) {
        id = counter++;
        //System.out.println("id: "+ id);
        this.items = items;
        this.type = type;
        this.amount = amount;
        this.transactionOrder = transactionOrder;
    }

    public int getId() {
        return id;
    }

    public List<Item> getItems() {
        return items;
    }

    public ItemType getType() {
        return type;
    }

    public int getAmount() {
        return amount;
    }

    public Order getTransactionOrder() {
        return transactionOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "\nTransaction{" +
                "id=" + id + "\n" +
                //", items=" + items +
                ", type=" + type + "\n" +
                ", amount=" + amount + "\n" +
                ", transactionOrder=" + transactionOrder +
                '}';
    }
}
