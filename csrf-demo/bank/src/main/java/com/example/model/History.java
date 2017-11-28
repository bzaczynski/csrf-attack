
package com.example.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class History {

    private List<Pair<String, Double>> transfers = new ArrayList<>();

    public List<Pair<String, Double>> all() {
        List<Pair<String, Double>> copy = new ArrayList(transfers);
        Collections.reverse(copy);
        return copy;
    }

    public void store(String accountNumber, Double amount) {
        transfers.add(new Pair(accountNumber, amount));
    }
}
