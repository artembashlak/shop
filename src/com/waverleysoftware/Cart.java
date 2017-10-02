package com.waverleysoftware;

import java.util.ArrayList;
import java.util.Scanner;

public class Cart {
    private ArrayList<Product> myCart = new ArrayList<>();

    public Cart() {
    }

    public void addToCart() {
        myCart.add(createProduct());
    }

    public void deleteFromCart() {
        Scanner in = new Scanner(System.in);
        System.out.println("Gimme name of the product to delete");
        String nameOfProduct = in.nextLine();
        for (Product product : myCart) {
            if (product.getName().equals(nameOfProduct)) {
                System.out.println("Product is in your cart!");
                int amoutToReduceBy = changeQuantity();
                product.setQuantity(product.getQuantity() - amoutToReduceBy);
            }
        }
    }

    private int changeQuantity() {
        Scanner in = new Scanner(System.in);
        System.out.println("How much do you want to reduce amount of selected product by?");
        boolean continueOperation = false;
        String amountOfProductToReduce = "";
        while (!continueOperation) {
            amountOfProductToReduce = in.nextLine();
            if (qtyContainsInteger(amountOfProductToReduce)) {
                continueOperation = true;
            }
        }

        return Integer.parseInt(amountOfProductToReduce);
    }

    public String showWhatInCart() {
        StringBuilder sb = new StringBuilder();
        myCart.stream().forEach((Product ->
        {
            sb.append(Product);
        }
        ));
        return sb.toString();
    }

    private Product createProduct() {
        Scanner in = new Scanner(System.in);
        boolean isOK = false;
        int quantity = 0;
        double price = 0;
        String fromScanner;
        String name = "";
        System.out.println("Let's assemble product together!");
        while (!isOK) {
            System.out.println("Give product's name:");
            name = in.nextLine();
            if (nameContainsLettersOnly(name)) {
                System.out.println("Name " + name + " is okay");
                isOK = true;
            } else {
                System.out.println("Name contains numeric values. Redo, please!");
            }
        }
        isOK = false;
        while (!isOK) {
            System.out.println("Give product's price:");
            fromScanner = in.nextLine();
            if (priceContainsDigitsOnly(fromScanner)) {
                price = Double.parseDouble(fromScanner);
                System.out.println("Price " + price + " is okay");
                isOK = true;
            } else {
                System.out.println("Incorrect price entry. Check for it to be digits only!");
            }
        }
        isOK = false;
        while (!isOK) {
            System.out.println("Give product's quantity:");
            fromScanner = in.nextLine();
            if (qtyContainsInteger(fromScanner)) {
                quantity = Integer.parseInt(fromScanner);
                System.out.println("Quantity " + quantity + " is okay");
                isOK = true;
            }
        }
        return new Product(name, price, quantity);
    }

    private boolean nameContainsLettersOnly(String input) {
        return input.chars().allMatch(Character::isLetter);
    }

    private boolean priceContainsDigitsOnly(String input) {
        try {
            Double.parseDouble(input);
        } catch (NumberFormatException e) {
            System.out.println("Please enter valid value!");
            return false;
        }
        return true;
    }

    private boolean qtyContainsInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Please enter valid value!");
            return false;
        }
        return true;
    }
}
