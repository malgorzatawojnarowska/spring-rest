package spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ComponentScan("spring")
public class SpringConfig {

    @Bean("meals")
    List<String> meals(){
        return new ArrayList<>(List.of(
                "hamburger",
                "coca-cola"
        ));
    }

    @Bean
    String name(){
        return "Summer holiday 2024";
    }
}
