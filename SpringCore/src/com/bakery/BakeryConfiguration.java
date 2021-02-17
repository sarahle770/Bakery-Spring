package com.bakery;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * This file is a part of SpringCore project.
 *
 * @author Sarah Cynamon
 * @version 1.0.0
 */
@Configuration
/*which package should scanned*/
@ComponentScan("com")
@PropertySource("classpath:bakery.properties")
@EnableScheduling
public class BakeryConfiguration {
}
