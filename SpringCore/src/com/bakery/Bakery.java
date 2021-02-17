package com.bakery;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * This file is a part of SpringCore project.
 *
 * @author Sarah Cynamon
 * @version 1.0.0
 */
public class Bakery {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BakeryConfiguration.class);

        Oven oven = context.getBean("oven", Oven.class);

        oven.setListener(new OnOvenCompleteListener() {
            @Override
            public void onOvenComplete() {
                System.out.println("Bakery is closed!");
                context.close();
            }
        });

    }
}
