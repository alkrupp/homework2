package homework;

import java.util.*;
import java.util.stream.Collectors;
// class Stoke
// поля
// String name
// List<Item> itemsList
// Set<Order> orders

// конструкторы
// (String name)

// методы
//getter/setter/toString

public class Stock {
    private final String name;
    private final List<Item> items;
    private final Set<Order> orders;
    private final Set<Transaction> transactions;

    public Stock(String name) {
        this.name = name;
        items = new ArrayList<>();
        orders = new HashSet<>();
        transactions = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public List<Item> getItemsList() {
        return items;
    }

    public Set<Transaction> getItemTransactions(ItemType itemType) {
//        Set<Transaction> temp = new HashSet<>();
//        for (Transaction transaction : transactions) {
//            // for(int i =0; i < transactions.size(); i++){
//            // так нельзя в Set,Map в List можно if (transactions.g)
//            if (transaction.getType() == itemType) {
//                temp.add(transaction);
//            }
//        }
//        return temp;
        return transactions.stream()
                .filter((Transaction x)-> x.getType()== itemType)
                .collect(Collectors.toSet());
    }

//    public void addItems(ItemType type, double price, int amount) {
//        for (int i = 0; i < amount; i++) {
//            items.add(new Item(type, price));
//        }
//    }

    public int getAvailable(ItemType itemType) {
        int count = 0;
        for (Item item : items) {
            if (item.getType() == itemType) {
                count++;
            }
        }
        return count;
    }

    public void receive(Order order) {
        items.addAll(order.getItems());
        addTransaction(order, true);
    }

    // удаляет всё внутпи order
    public void dispatch(Order order) {
        for (int i = 0; i < items.size(); i++) {
            for (Item item : order.getItems()) {
                if (items.get(i).equals(item)) {
                    items.remove(i);
                    i--;
                    break;
                }
            }
        }
        addTransaction(order, false);
    }

    private void addTransaction(Order order, boolean positive) {
        //for (ItemType itemType : ItemType.values()) {
        Map<ItemType, Integer> tempMap = new EnumMap<>(ItemType.class);
        //System.out.println("tempMAp test" + tempMap);
        List<Item> tempList = new ArrayList<>();
        for (Item item : order.getItems()) {
//                if (item.getType() == itemType) {
            //tempMap.computeIfAbsent(item.getType(), (k, v) -> v == null ? 0 : v + 1);
            tempMap.merge(item.getType(), 1, (Integer a, Integer b) -> {
                return Integer.sum(a, b);
            });
            tempList.add(item);
//                }
        }
        for (Map.Entry<ItemType, Integer> entry : tempMap.entrySet()) {
            var amount = positive ? entry.getValue() : entry.getValue() * (-1); // if
            Transaction transaction = new Transaction(tempList, entry.getKey(), order, amount);
            addTransaction(transaction);
            //System.out.println(entry.getKey() + " - " + entry.getValue());
        }
//        int amount = positive ? tempList.size() : tempList.size() * (-1);
//        if (amount != 0) {
//            Transaction transaction = new Transaction(tempList, itemType, order, amount);
//            //System.out.println(" zabil");
//            addTransaction(transaction);
//        }
        //  }
    }

    private void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        //System.out.println("doso?: "+ transaction);
    }


    public void validateIntegrity() {
        for (ItemType itemType : ItemType.values()) {
            long amountInStock = items.stream()
                    .filter((Item x) -> x.getType() == itemType)
                    .count();
            long amountInTransactions = transactions.stream()
                    .filter((Transaction x) -> x.getType() == itemType)
                    .map(Transaction::getAmount)
                    .reduce(0, (Integer x, Integer y) -> x + y); // Integer::sum()

            if (amountInStock == amountInTransactions) {
                System.out.println(itemType + " OK " + amountInStock + " - " + amountInTransactions);
            } else {
                System.out.println(itemType + " NOT OK " + amountInStock + " - " + amountInTransactions);
            }
        }
    }

//    public void (){
//
//    }

    public Set<Order> getOrders() {
        return orders;
    }

//    public void addItem(Order order) {
//        orders.add(order);
//    }

    private String getItemsAsString() {
        StringBuilder result = new StringBuilder();
        for (Item item : items) {
            result.append(item).append("\n");
        }
        return result.toString();
    }

    private String getOrdersAsString() {
        StringBuilder result = new StringBuilder();
        for (Order order : orders) {
            result.append(order).append("\n");
        }
        return result.toString();
    }

    @Override
    public String toString() {
        return "Stoke{" + "\n" +
                "name='" + name + ",\n" +
                "items=" + getItemsAsString() +
                "orders=" + getOrdersAsString() + "\n" +
                '}';
    }
}
