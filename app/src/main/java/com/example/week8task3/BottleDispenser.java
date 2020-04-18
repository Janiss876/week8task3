package com.example.week8task3;

import android.widget.TextView;

import java.util.ArrayList;

public class BottleDispenser {

    private static BottleDispenser bd = new BottleDispenser();

    private int bottles;
    private ArrayList<Bottle> bottle_array = new ArrayList<Bottle>();
    private float money;

    private BottleDispenser() {
        bottles = 5;
        money = 0;
        for (int i = 0; i < bottles; i++) {
            bottle_array.add(new Bottle());
        }
    }

    public static BottleDispenser getInstance() {
        return bd;
    }

    public void addMoney(TextView f, double m) {
        money += m;
        f.setText("Klink! Added " + m + "€!");

    }

    public void buyBottle(int b, TextView f) {

        if (bottles <= 0) {
            f.setText("There are no bottles!");

        } else if (money < bottle_array.get(b - 1).getPrice()) {
            f.setText("Add money first!");

        } else {
            money -= bottle_array.get(b - 1).getPrice();
            bottles -= 1;
            f.setText(bottle_array.get(b - 1).getName() + " came out of the dispenser!");
            bottle_array.remove(b - 1);
        }

    }

    public void returnMoney(TextView f) {

        String moneys = String.format("%.2f", money);
        f.setText("You got " + moneys + "€ back!");
        money = 0;

    }

}
