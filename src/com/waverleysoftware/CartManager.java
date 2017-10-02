package com.waverleysoftware;

import java.util.Scanner;

public class CartManager {
    private Cart cart = new Cart();

    public CartManager() {}

    public void getInput() {
        Scanner in = new Scanner(System.in);
        System.out.println("Type a command(add, remove, show or exit):");
        String input = in.nextLine();
        switch (input) {
            case "add": cart.addToCart();
                break;
            case "remove": cart.deleteFromCart();
                break;
            case "show": cart.showWhatInCart();
                break;
            case "exit": System.exit(0);
            default: getInput();
        }
    }
}