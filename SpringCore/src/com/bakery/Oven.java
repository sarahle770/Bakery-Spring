package com.bakery;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * This file is a part of SpringCore project.
 *
 * @author Sarah Cynamon
 * @version 1.0.0
 */
@Component
public class Oven {
    private final List<Bread> content;
    private OnOvenCompleteListener listener;
    private boolean on;

    public Oven() {
        content = new ArrayList<>();
        on = true;
    }

    public void addBread(Bread bread) {
        content.add(bread);
    }

    @Scheduled(fixedRateString = "${rate.oven}")
    void bake() {
        Iterator<Bread> iterator = content.iterator();

        while (iterator.hasNext()) {
            Bread bread = iterator.next();

            if (bread.isReady()) {
                iterator.remove();
                System.out.printf("Oven - %s is ready!\n", bread);
            } else {
                bread.bake();
                System.out.printf("Oven - baking %s...\n", bread);
            }
        }
        if (content.isEmpty() && !on) {
            listener.onOvenComplete();
        }
    }

    public void setListener(OnOvenCompleteListener listener) {
        this.listener = listener;
    }

    public void turnOffOnBakeComplete() {
        on = false;
    }
}

