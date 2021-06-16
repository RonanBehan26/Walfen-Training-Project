package com.walfen.training.api.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;

import com.walfen.training.api.entities.Address;
import com.walfen.training.api.entities.Zoo;
import com.walfen.training.api.services.ZooService;
import com.walfen.training.api.zoo.Animal;
import com.walfen.training.api.zoo.Tiger;
import com.walfen.training.api.zoo.Zebra;


@Service
public class ZooServiceImpl implements ZooService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ZooServiceImpl.class);

	@Override
	public List<Zoo> list() {
		LOGGER.info("list zoos");
				
		List<Zoo> allZoos = new ArrayList<>();
		
		List<Animal> animalsListOne = new ArrayList<>();
		List<Animal> animalsListTwo = new ArrayList<>();
		List<Animal> animalsListThree = new ArrayList<>();
				
		Animal tigerOne = new Tiger("Tony");
		Animal tigerTwo = new Tiger("John");
		Animal tigerThree = new Tiger("Pat");
		animalsListOne.add(tigerOne);
		animalsListOne.add(tigerTwo);
		animalsListOne.add(tigerThree);
		
		Animal zebraOne = new Zebra("Zulu");
		Animal zebraTwo = new Zebra("South Africa");
		Animal zebraThree = new Zebra("Angola");
		animalsListTwo.add(zebraOne);
		animalsListTwo.add(zebraTwo);
		animalsListTwo.add(zebraThree);
			
		Animal sharkOne = new Zebra("Indian");
		Animal sharkTwo = new Zebra("Carribbean");
		Animal sharkThree = new Zebra("Antarctic");
		animalsListThree.add(sharkOne);
		animalsListThree.add(sharkTwo);
		animalsListThree.add(sharkThree);
		
		Zoo zooOne = new Zoo(1, "Chicago Zoo", "Chicago", animalsListOne);
		Zoo zooTwo = new Zoo(2, "London Zoo", "London", animalsListTwo);
		Zoo zooThree = new Zoo(3, "Madrid Zoo", "Madrid", animalsListThree);
		
		allZoos.add(zooOne);
		allZoos.add(zooTwo);
		allZoos.add(zooThree);
		
		return allZoos;
	}

	@Override
	public Zoo get(Long id) {
		LOGGER.info("get address - id: {}", id);
		
		List<Zoo> allZoos = new ArrayList<>();
		
		List<Animal> animalsListOne = new ArrayList<>();
		List<Animal> animalsListTwo = new ArrayList<>();
		List<Animal> animalsListThree = new ArrayList<>();
				
		Animal tigerOne = new Tiger("Tony");
		Animal tigerTwo = new Tiger("John");
		Animal tigerThree = new Tiger("Pat");
		animalsListOne.add(tigerOne);
		animalsListOne.add(tigerTwo);
		animalsListOne.add(tigerThree);
		
		Animal zebraOne = new Zebra("Zulu");
		Animal zebraTwo = new Zebra("South Africa");
		Animal zebraThree = new Zebra("Angola");
		animalsListTwo.add(zebraOne);
		animalsListTwo.add(zebraTwo);
		animalsListTwo.add(zebraThree);
			
		Animal sharkOne = new Zebra("Indian");
		Animal sharkTwo = new Zebra("Carribbean");
		Animal sharkThree = new Zebra("Antarctic");
		animalsListThree.add(sharkOne);
		animalsListThree.add(sharkTwo);
		animalsListThree.add(sharkThree);
		
		Zoo zooOne = new Zoo(1, "Chicago Zoo", "Chicago", animalsListOne);
		Zoo zooTwo = new Zoo(2, "London Zoo", "London", animalsListTwo);
		Zoo zooThree = new Zoo(3, "Madrid Zoo", "Madrid", animalsListThree);
		
		allZoos.add(zooOne);
		allZoos.add(zooTwo);
		allZoos.add(zooThree);
				
		return zooOne;
	}

	@Override
	public List<Animal> listAnimals(Long id) {

		List<Zoo> allZoos = new ArrayList<>();
		
		List<Animal> animalsListOne = new ArrayList<>();
		List<Animal> animalsListTwo = new ArrayList<>();
		List<Animal> animalsListThree = new ArrayList<>();
				
		Animal tigerOne = new Tiger("Tony");
		Animal tigerTwo = new Tiger("John");
		Animal tigerThree = new Tiger("Pat");
		animalsListOne.add(tigerOne);
		animalsListOne.add(tigerTwo);
		animalsListOne.add(tigerThree);
		
		Animal zebraOne = new Zebra("Zulu");
		Animal zebraTwo = new Zebra("South Africa");
		Animal zebraThree = new Zebra("Angola");
		animalsListTwo.add(zebraOne);
		animalsListTwo.add(zebraTwo);
		animalsListTwo.add(zebraThree);
			
		Animal sharkOne = new Zebra("Indian");
		Animal sharkTwo = new Zebra("Carribbean");
		Animal sharkThree = new Zebra("Antarctic");
		animalsListThree.add(sharkOne);
		animalsListThree.add(sharkTwo);
		animalsListThree.add(sharkThree);
		
		Zoo zooOne = new Zoo(1, "Chicago Zoo", "Chicago", animalsListOne);
		Zoo zooTwo = new Zoo(2, "London Zoo", "London", animalsListTwo);
		Zoo zooThree = new Zoo(3, "Madrid Zoo", "Madrid", animalsListThree);
		
		allZoos.add(zooOne);
		allZoos.add(zooTwo);
		allZoos.add(zooThree);
		
		return animalsListOne;
	}
	
	
	
}
