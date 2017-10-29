/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mkyong;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author Hubert
 */
public class Things {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Map<String, Integer> mapka = new HashMap<>();
        mapka.put("A", 10);
        mapka.put("B", 20);
        mapka.put("C", 30);
        mapka.put("D", 40);
        mapka.put("E", 50);
        mapka.put("F", 60);

//        for (Map.Entry<String, Integer> entry: mapka.entrySet())
//            System.out.println("Item " + entry.getKey() + ", value " + entry.getValue());
        mapka.forEach((k, v) -> System.out.println("Item " + k + ", value " + v));

        System.out.println("");

        List<String> things = Arrays.asList("apple", "apple", "banana", "apple", "orange", "banana", "papaya");

        Map<String, Long> result = things.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(result);
//        
        Map<String, Long> finalMap = new LinkedHashMap<>();

        result.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed()).forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));
        System.out.println(finalMap);

        List<Item> items = Arrays.asList(
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 20, new BigDecimal("19.99")),
                new Item("orange", 10, new BigDecimal("29.99")),
                new Item("watermelon", 10, new BigDecimal("29.99")),
                new Item("papaya", 20, new BigDecimal("9.99")),
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 10, new BigDecimal("19.99")),
                new Item("apple", 20, new BigDecimal("9.99"))
        );
        
        
        Map<String, Long> counting = items.stream()
                .collect(Collectors.groupingBy(Item::getName,Collectors.counting()));
        System.out.println( counting);
     
        Map<String, Integer> sum = items.stream()
                .collect(Collectors.groupingBy(Item::getName, Collectors.summingInt(Item::getQty)));
        
        System.out.println(sum);
        
        
        Map<BigDecimal, List<Item>> groupByPriceMap = items.stream().collect(Collectors.groupingBy(Item::getPrice));
        
        System.out.println(groupByPriceMap);
        
        
        Stream<String> language = Stream.of("java","python", "node", null, "ruby", null, "php");
        List<String> filteredLanguage = language.filter(x-> x!=null).collect(Collectors.toList());
        filteredLanguage.forEach(System.out::println);
        
        
        
    }

}

class Item {

    private String name;
    private int qty;
    private BigDecimal price;

    public Item(String name, int qty, BigDecimal price) {
        this.name = name;
        this.qty = qty;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getQty() {
        return qty;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Item{" + "name=" + name + ", qty=" + qty + ", price=" + price + '}';
    }
    
    

}
