package spring.config;

import org.springframework.context.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ComponentScan("spring")
@PropertySource("classpath:/meals.properties")
@EnableAspectJAutoProxy
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
