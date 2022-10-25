package homework;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        var stock = new Stock("Maxima");

        var item1 = new Item(ItemType.BREAD, 0.59);
        var item2 = new Item(ItemType.MILK, 0.99);
        var item3 = new Item(ItemType.BREAD, 0.99);
        List<Item> itemList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                var temp = new Item(ItemType.BREAD, 0.5);
                itemList.add(temp);
            } else {
                var temp = new Item(ItemType.MILK, 1);
                itemList.add(temp);
            }
        }

        Order order = new Order();
        order.addItems(itemList);
//        order.addItem(item1);
//        order.addItem(item2);
//        order.addItem(item3);
        stock.receive(order);
        getStockState(stock);

//        System.out.println(stock.getAvailable(ItemType.MILK));
//        System.out.println(stock.getAvailable(ItemType.BREAD));

        Order order2 = new Order();
        List<Item> list2 = itemList.stream()
                .filter((Item x) -> x.getType() == ItemType.MILK).toList();
        order2.addItems(list2);
//        order2.addItem(item2);
//        order2.addItem(item3);
//        order2.addItem(item1);
        stock.dispatch(order2);


        //System.out.println(stock);
//        System.out.println(stock.getAvailable(ItemType.MILK));
//        System.out.println(stock.getAvailable(ItemType.BREAD));

        System.out.println(stock.getItemTransactions(ItemType.MILK));
        System.out.println("------------------");
        System.out.println(stock.getItemTransactions(ItemType.BREAD));
        getStockState(stock);
        System.out.println("------------------");
        System.out.println(order.getTotal());
        stock.validateIntegrity();
    }

    private static void getStockState(Stock stock) {
        for (ItemType itemType : ItemType.values()) {
            System.out.println(itemType + " - " + stock.getAvailable(itemType));
        }
    }
}
// продумать логику списывания со склада
// история транзакции
