package com.example.blog.users;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository) {
        return args -> {
            Users u1 = new Users(
                    "Temam Hashim",
                    "temam@gmail.com",
                    "0985130393",
                    LocalDate.of(1998, Month.JANUARY, 20)
            );
            Users u2 = new Users(
                    "Sara Abrham",
                    "sara@gmail.com",
                    "0985130393",
                    LocalDate.of(1997, Month.APRIL, 12)
            );

            //            save all user to db
//            repository.saveAll(
//                    List.of(u1,u2)
//            );
        };
    }
}
