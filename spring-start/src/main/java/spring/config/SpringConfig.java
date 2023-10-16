package spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SpringConfig {

    @Bean("meals")
    List<String> meals(){
        return List.of(
             "hamburger",
             "coca-cola"
        );
    }

    @Bean
    String name(){
        return "Summer holiday 2024";
    }

}
