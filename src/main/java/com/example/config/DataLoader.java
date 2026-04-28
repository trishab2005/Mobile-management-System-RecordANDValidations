package com.example.config;

import com.example.entity.Mobile;
import com.example.repository.MobileRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class DataLoader {

    @Bean
    public CommandLineRunner callMe(MobileRepository mobileRepository) {
        return args -> {
            mobileRepository.save(Mobile.builder().brand("samsung").model("a26").price(90000.0).stock(10).build());
            mobileRepository.save(Mobile.builder().brand("nokia").model("111").price(1000.0).stock(100).build());
            mobileRepository.save(Mobile.builder().brand("lava").model("777").price(10000.0).stock(1000).build());
            mobileRepository.save(Mobile.builder().brand("realme").model("guru").price(2000.0).stock(2000).build());
        };
    }


}
