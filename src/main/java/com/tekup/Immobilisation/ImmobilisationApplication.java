package com.tekup.Immobilisation;
import java.io.IOException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.tekup.Immoblisation.Properties.FileStorageProperties;



@SpringBootApplication
@EnableConfigurationProperties({FileStorageProperties.class})
public class ImmobilisationApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(ImmobilisationApplication.class, args);
		
	}
	
}
