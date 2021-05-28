package com.walfen.training.api.zoo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class ZooTest {
//The test should have a method that creates a zoo 
	//and prints its properties 
	//(e.g. name, city, number of animals)
	
	
	@Test
	public void testZoo(){
	    	Zoo zoo = new Zoo();
	    	
	    	
	    	
	    	zoo.getAnimals();
	    	
	    	System.out.println(zoo.getAnimalsSize());
	    	System.out.println(zoo.getName());
	    	System.out.println(zoo.getCity());
	    	
	    }
	    
	}
	
	
	
	

