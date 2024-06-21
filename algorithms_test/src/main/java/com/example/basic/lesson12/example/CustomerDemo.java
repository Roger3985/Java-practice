package com.example.basic.lesson12.example;

import java.util.Arrays;

import static java.lang.System.out;
import static java.util.Comparator.comparing;

/**
 * @author Roger
 * @version Java 17
 */
public class CustomerDemo {
    public static void main(String[] args) {
        var customers = Arrays.asList(
                new Customer("Justin", "Lin", 804),
                new Customer("Monica", "Huang", 804),
                new Customer("Irene", "Lin", 804)
        );

        var byLastName = comparing(Customer::lastName);

        customers.sort(
                byLastName
                        .thenComparing(Customer::firstName)
                        .thenComparing(Customer::zipCode)
        );

        customers.forEach(out::println);
    }
}

record Customer(String firstName, String lastName, Integer zipCode) {}
