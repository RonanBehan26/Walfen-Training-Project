package com.walfen.training.api.daos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.walfen.training.api.dtos.AnimalDto;
import com.walfen.training.api.dtos.TigerDto;
import com.walfen.training.api.entities.Zoo;
import com.walfen.training.api.zoo.Animal;
import com.walfen.training.api.zoo.Shark;
import com.walfen.training.api.zoo.Tiger;
import com.walfen.training.api.zoo.Zebra;

@Component
public class ZooDaoImpl implements ZooDao{

	@Override
	public List<Zoo> findAll() {
		
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
		
			Animal sharkOne = new Shark("Indian");
			Animal sharkTwo = new Shark("Carribbean");
			Animal sharkThree = new Shark("Antarctic");
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
	public Optional<Zoo> findById(Long id) {
						
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
		
			Animal sharkOne = new Shark("Indian");
			Animal sharkTwo = new Shark("Carribbean");
			Animal sharkThree = new Shark("Antarctic");
			animalsListThree.add(sharkOne);
			animalsListThree.add(sharkTwo);
			animalsListThree.add(sharkThree);
		
			Zoo zooOne = new Zoo(1, "Chicago Zoo", "Chicago", animalsListOne);
			Zoo zooTwo = new Zoo(2, "London Zoo", "London", animalsListTwo);
			Zoo zooThree = new Zoo(3, "Madrid Zoo", "Madrid", animalsListThree);
		
			allZoos.add(zooOne);
			allZoos.add(zooTwo);
			allZoos.add(zooThree);
		
			return Optional.ofNullable(zooOne);
	}

	
	@Override
	public List<Animal> findAnimalsById(Long id) {
		
		List<Animal> animalsListOne = new ArrayList<>();
		
			Animal tigerOne = new Tiger("Tony");
			Animal tigerTwo = new Tiger("John");
			Animal tigerThree = new Tiger("Pat");
			animalsListOne.add(tigerOne);
			animalsListOne.add(tigerTwo);
			animalsListOne.add(tigerThree);
		
			return animalsListOne;
	}


}

//
//private static final Logger LOGGER = LoggerFactory.getLogger(ZooServiceImpl.class);
//
//@Override
//public List<Zoo> list() {
//	LOGGER.info("list zoos");
//
//	List<Zoo> allZoos = new ArrayList<>();
//
//	List<Animal> animalsListOne = new ArrayList<>();
//	List<Animal> animalsListTwo = new ArrayList<>();
//	List<Animal> animalsListThree = new ArrayList<>();
//
//	Animal tigerOne = new Tiger("Tony");
//	Animal tigerTwo = new Tiger("John");
//	Animal tigerThree = new Tiger("Pat");
//	animalsListOne.add(tigerOne);
//	animalsListOne.add(tigerTwo);
//	animalsListOne.add(tigerThree);
//
//	Animal zebraOne = new Zebra("Zulu");
//	Animal zebraTwo = new Zebra("South Africa");
//	Animal zebraThree = new Zebra("Angola");
//	animalsListTwo.add(zebraOne);
//	animalsListTwo.add(zebraTwo);
//	animalsListTwo.add(zebraThree);
//
//	Animal sharkOne = new Shark("Indian");
//	Animal sharkTwo = new Shark("Carribbean");
//	Animal sharkThree = new Shark("Antarctic");
//	animalsListThree.add(sharkOne);
//	animalsListThree.add(sharkTwo);
//	animalsListThree.add(sharkThree);
//
//	Zoo zooOne = new Zoo(1, "Chicago Zoo", "Chicago", animalsListOne);
//	Zoo zooTwo = new Zoo(2, "London Zoo", "London", animalsListTwo);
//	Zoo zooThree = new Zoo(3, "Madrid Zoo", "Madrid", animalsListThree);
//
//	allZoos.add(zooOne);
//	allZoos.add(zooTwo);
//	allZoos.add(zooThree);
//
//	return allZoos;
//}
//
//@Override
//public Zoo get(Long id) {
//	LOGGER.info("get address - id: {}", id);
//
//	List<Zoo> allZoos = new ArrayList<>();
//
//	List<Animal> animalsListOne = new ArrayList<>();
//	List<Animal> animalsListTwo = new ArrayList<>();
//	List<Animal> animalsListThree = new ArrayList<>();
//
//	Animal tigerOne = new Tiger("Tony");
//	Animal tigerTwo = new Tiger("John");
//	Animal tigerThree = new Tiger("Pat");
//	animalsListOne.add(tigerOne);
//	animalsListOne.add(tigerTwo);
//	animalsListOne.add(tigerThree);
//
//	Animal zebraOne = new Zebra("Zulu");
//	Animal zebraTwo = new Zebra("South Africa");
//	Animal zebraThree = new Zebra("Angola");
//	animalsListTwo.add(zebraOne);
//	animalsListTwo.add(zebraTwo);
//	animalsListTwo.add(zebraThree);
//
//	Animal sharkOne = new Shark("Indian");
//	Animal sharkTwo = new Shark("Carribbean");
//	Animal sharkThree = new Shark("Antarctic");
//	animalsListThree.add(sharkOne);
//	animalsListThree.add(sharkTwo);
//	animalsListThree.add(sharkThree);
//
//	Zoo zooOne = new Zoo(1, "Chicago Zoo", "Chicago", animalsListOne);
//	Zoo zooTwo = new Zoo(2, "London Zoo", "London", animalsListTwo);
//	Zoo zooThree = new Zoo(3, "Madrid Zoo", "Madrid", animalsListThree);
//
//	allZoos.add(zooOne);
//	allZoos.add(zooTwo);
//	allZoos.add(zooThree);
//
//	return zooOne;
//}
//
//@Override
//public List<AnimalDto> listAnimals(Long id) {
//
//	List<AnimalDto> animalsListOne = new ArrayList<>();
//
//	AnimalDto tigerOne = new TigerDto("Tony");
//	AnimalDto tigerTwo = new TigerDto("John");
//	AnimalDto tigerThree = new TigerDto("Pat");
//	animalsListOne.add(tigerOne);
//	animalsListOne.add(tigerTwo);
//	animalsListOne.add(tigerThree);
//
//	return animalsListOne;
//}
