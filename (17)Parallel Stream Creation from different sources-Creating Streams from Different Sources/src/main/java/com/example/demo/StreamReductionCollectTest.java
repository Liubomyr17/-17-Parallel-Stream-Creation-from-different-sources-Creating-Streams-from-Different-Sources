package com.example.demo;

import java.util.*;
import java.util.stream.Collectors;

public class StreamReductionCollectTest {

    public static void main(String[] args) {

    List<Product> productList = Arrays.asList(new Product(23, "potatoes"),
            new Product(14, "orange"), new Product(13, "lemon"),
            new Product(23, "bread"), new Product(13, "sugar"));

        //method1(productList);
        Map<Boolean, List<Product>> collect = productList.stream().collect(Collectors.partitioningBy(p->p.getPrice()>15));
        collect.forEach((k,v)->{
            System.out.println(k);
            System.out.println(v);
        });

        System.out.println("------------------------------------------------------");

        Set<Product> collect2 = productList.stream().collect(Collectors.collectingAndThen(Collectors.toSet(), Collections::unmodifiableSet));
        collect2.forEach(System.out::println);
    }

    private static void method1(List<Product> productList) {
        List<String> collect = productList.stream().map(Product::getName).collect(Collectors.toList());
        collect.forEach(System.out::println);
        // Converting stream to collection
        System.out.println("------------------------------------------");
        // Reduce to String
        String collect2 = productList.stream().map(Product::getName).collect(Collectors.joining(",", "[", "]"));
        System.out.println(collect2);
        System.out.println("------------------------------------------");
        // Average price
        Double averagePrice = productList.stream().collect(Collectors.averagingInt(Product::getPrice));
        System.out.println(averagePrice);
    }
}
