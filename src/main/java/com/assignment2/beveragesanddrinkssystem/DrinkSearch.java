package com.assignment2.beveragesanddrinkssystem;

import Model.Drink;

import java.util.List;
import java.util.stream.Collectors;

public class DrinkSearch {
    public static List<Drink> searchByName(List<Drink> drinks, String keyword) {
        return drinks.stream()
                .filter(drink -> drink.getName().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }

    public static List<Drink> searchByDescription(List<Drink> drinks, String keyword) {
        return drinks.stream()
                .filter(drink -> drink.getDescription().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }
}
