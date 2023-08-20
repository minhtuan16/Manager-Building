// Quản lý tòa nhà
package com.example.demo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.example.demo.entity.Role;
import com.example.demo.entity.ServiceEntity;
import com.example.demo.entity.User;
import com.example.demo.repository.IServiceRepository;
import com.example.demo.service.IUserService;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
 
@SpringBootApplication 
@EnableSwagger2
public class DemoApplication {
    @Autowired
    private IUserService userService;
    @Autowired
    private IServiceRepository serviceRepository;
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
 
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*");
            }
        };
    }

    @PostConstruct
    public void init() {
        List<User> users = userService.findAll();

        if (users.isEmpty()) {
            User admin = new User();
            Set<Role> roles = new HashSet<>();
            Role roleAdmin = new Role();
            roleAdmin.setName("ROLE_ADMIN");
            roles.add(roleAdmin);
            admin.setFullName("Minh Tuân");
            admin.setUsername("admin");
            admin.setPassword("123");
            admin.setRoles(roles);
            userService.save(admin);
        }

        List<ServiceEntity> requiredServices = serviceRepository.findServiceEntitiesByRequired(1);
        if(requiredServices.isEmpty()){
            ServiceEntity serviceEntity = new ServiceEntity();
            serviceEntity.setName("Vệ sinh");
            serviceEntity.setRequired(1);
            serviceEntity.setPrice(1500000);
            serviceEntity.setType("Dịch vụ bắt buộc");
            serviceRepository.save(serviceEntity);
            ServiceEntity serviceEntity1 = new ServiceEntity();
            serviceEntity1.setName("Bảo vệ");
            serviceEntity1.setRequired(1);
            serviceEntity1.setPrice(2000000);
            serviceEntity1.setType("Dịch vụ bắt buộc");
            serviceRepository.save(serviceEntity1);
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
    
    public Docket apis() {
    	return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.example.demo")).build();
    }

}
