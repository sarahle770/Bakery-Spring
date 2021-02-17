package com.bakery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * This file is a part of SpringCore project.
 *
 * @author Sarah Cynamon
 * @version 1.0.0
 */
@Component
public class Worker {
    private final Oven oven;
    private final int totalBread;
    private int breadCounter;

    @Autowired
    public Worker(Oven oven, @Value("${total.bread}") int totalBread) {
        this.oven = oven;
        this.totalBread = totalBread;
    }

    @Scheduled(fixedRateString = "${rate.worker}")
    public void feedTheOven() {
        if (breadCounter < totalBread) {
            System.out.printf("Worker- Putting bread number%d in the oven.\n", ++breadCounter);
            oven.addBread(new Bread("#" + breadCounter));
        } else {
            oven.turnOffOnBakeComplete();
        }
    }
}
