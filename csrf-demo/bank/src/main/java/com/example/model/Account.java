package com.example.model;

import org.springframework.stereotype.Component;

@Component
public class Account {

    private static double INITIAL_BALANCE = 14367.21;

    private double balance = INITIAL_BALANCE;
    private History history = new History();

    public double getBalance() {
        return balance;
    }

    public History getHistory() {
        return history;
    }

    public boolean transferTo(String accountNumber, double amount) {

        if (amount <= 0) {
            return false;
        }

        double newBalance = balance - amount;

        if (newBalance >= 0) {

            log("Transferred $" + amount + " to \"" + accountNumber + "\" account.");

            balance = newBalance;
            history.store(accountNumber, amount);
            return true;
        } else {

            log("Not enough money to make the transfer of $" + amount + "!");

            return false;
        }
    }

    private void log(String message) {
        System.out.println(message);
    }
}
