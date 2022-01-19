package com.example;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapExample {

	public static void main(String[] args) {
		List<String> names = Arrays.asList("Java", "Stream", "Filter", "expression", "Lambda");
		names.stream().filter(name -> name.contains("a")).flatMap(name -> Stream.of(name + " API")).map(User::new)
				.forEach(System.out::println);

		System.out.println("====================");
		Optional<String> name = names.stream()
				.map(name2 -> Stream.of(name2)).flatMap(stream -> stream.filter(name3 -> name3.contains("a") && name3.contains("S")))
				.findAny();
		name.ifPresent(System.out::println);
		
		System.out.println("====================");
		
		 // Creating a list of Prime Numbers
        List<Integer> PrimeNumbers = Arrays.asList(5, 7, 11,13);
          
        // Creating a list of Odd Numbers
        List<Integer> OddNumbers = Arrays.asList(1, 3, 5);
          
        // Creating a list of Even Numbers
        List<Integer> EvenNumbers = Arrays.asList(2, 4, 6, 8);
  
        List<List<Integer>> listOfListofInts =
                Arrays.asList(PrimeNumbers, OddNumbers, EvenNumbers);
  
        System.out.println("The Structure before flattening is : " +
                                                  listOfListofInts);
          
        // Using flatMap for transformating and flattening.
        List<Integer> listofInts  = listOfListofInts.stream()
                                    .flatMap(list -> list.stream())
                                    .collect(Collectors.toList());
  
        System.out.println("The Structure after flattening is : " +
                                                         listofInts);
        System.out.println("====================");
        Integer streamAddResult = Stream.of(1,3,2,5,6,9).reduce(0, (a,b) -> a+b);
        System.out.println(streamAddResult);
        
        System.out.println("====================");
        Integer streamMutiplyResult = Stream.of(1,3,2).reduce(1, (a,b) -> a*b);
        System.out.println(streamMutiplyResult);
        
        System.out.println("====================");
        Integer maxValue = Stream.of(1,3,17,2,5,6,9).reduce(Integer::max).get();
        System.out.println(maxValue);
        
        System.out.println("====================");
        Integer minValue = Stream.of(1,3,17,2,5,6,9).reduce(Integer::min).get();
        System.out.println(minValue);
       
        
        System.out.println("====================");
        Random random = new Random();
        random.ints().limit(5).sorted().forEach(System.out::println);
	}

}

class User {

	private String name;

	public User(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "User [name=" + name + "]";
	}

}