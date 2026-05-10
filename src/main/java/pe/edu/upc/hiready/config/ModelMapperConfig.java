package pe.edu.upc.hiready.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        //  Bean de ModelMapper para automatizar el mapeo entre entidades JPA y objetos DTO
        return new ModelMapper();
    }
}
