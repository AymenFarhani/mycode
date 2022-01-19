package com.example;

import java.util.Arrays;
import java.util.List;

public class FilterExample {

	public static void main(String[] args) {
		List<String> names = Arrays.asList("Java", "Stream", "Filter", "expression", "Lambda");
		names.stream().filter(name -> name.contains("a")).forEach(System.out::println);
		System.out.println("====================");
		names.stream().filter(FilterExample::isNameLengthSupTo4).map(Api::new).forEach(System.out::println);
		System.out.println("====================");
		names.stream().filter(FilterExample::isNameLengthSupTo4).mapToLong(name -> name.length())
				.forEach(System.out::println);
		System.out.println("====================");
		long sum = names.stream().filter(FilterExample::isNameLengthSupTo4).mapToLong(name -> name.length()).sum();
		System.out.println(sum);
	}

	private static boolean isNameLengthSupTo4(String name) {
		return name.length() > 4;
	}

}

class Api {
	String name;

	public Api(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Api [name=" + name + "]";
	}

}
