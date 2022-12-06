package com.team.fashionStore;

import com.team.fashionStore.configs.AppConstants;
import com.team.fashionStore.pojo.Role;
import com.team.fashionStore.repositories.RoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class FashionStoreApplication implements CommandLineRunner{
        
	public static void main(String[] args) {
		SpringApplication.run(FashionStoreApplication.class, args);
                
	}
        
        @Bean
        public ModelMapper modelMapper(){
            return new ModelMapper();
        }
       
       
        
        
    @Override
    public void run(String... args) throws Exception {
       
      }
   
}
