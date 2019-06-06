package ca.masoud.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

// Here we just introduced the path Spring should search for different Beans
@Configuration
@EnableWebMvc
@ComponentScan("ca.masoud")
public class Config {

} 